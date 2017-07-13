package com.example.linneabark.test;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.chl.leep.model.LeepModel;

/**
 * Created by linneabark on 2017-05-28.
 *
 *
 * Class that decidecs which "category"-popup to show
 */

public class ShowCategoryPopUp {

    private EditText categoryEdit;
    private Button saveButtonCategory;
    private Button exitButtonCategory;

    public void showCategoryPopUp (final Context context, Activity activity, final String buttonTag) {
        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        View categoryLayout = inflater.inflate(R.layout.pop_up_category, null);
        helpBuilder.setView(categoryLayout);

        final AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();

        categoryEdit = (EditText) categoryLayout.findViewById(R.id.edit_text_category);
        categoryEdit.setText(getCategory(buttonTag), TextView.BufferType.EDITABLE);

        saveButtonCategory = (Button) categoryLayout.findViewById(R.id.save_button_category);
        saveButtonCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCategory(buttonTag);
                helpDialog.dismiss();
            }
        });

        exitButtonCategory = (Button) categoryLayout.findViewById(R.id.close_button_category);
        exitButtonCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helpDialog.dismiss();
            }
        });

    }

    private String getCategory(String buttontag){
        if (Integer.valueOf(buttontag) == 0){
            return LeepModel.getCategory1();
        }else if (Integer.valueOf(buttontag) == 1){
            return LeepModel.getCategory2();
        }else{
            return LeepModel.getCategory3();
        }
    }

    private void setCategory( String buttonTag){
        if (Integer.valueOf(buttonTag) == 0){
        LeepModel.setCategory1( categoryEdit.getText().toString());
    }   else if(Integer.valueOf(buttonTag) == 1){
            LeepModel.setCategory2(categoryEdit.getText().toString());
        }else {
            LeepModel.setCategory3(categoryEdit.getText().toString());
        }

}}
