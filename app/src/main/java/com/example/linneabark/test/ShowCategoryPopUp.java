package com.example.linneabark.test;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.chl.leep.model.Leep;

/**
 * Created by linneabark on 2017-05-28.
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
        categoryEdit.setText(getCategory(buttonTag, context), TextView.BufferType.EDITABLE);

        saveButtonCategory = (Button) categoryLayout.findViewById(R.id.save_button_category);
        saveButtonCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCategory(context, buttonTag);
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

    private String getCategory(String buttontag, Context context){
        if (Integer.valueOf(buttontag) == 0){
            return Leep.getCategory1(context);
        }else if (Integer.valueOf(buttontag) == 1){
            return Leep.getCategory2(context);
        }else{
            return Leep.getCategory3(context);
        }
    }

    private void setCategory(Context context, String buttonTag){
        if (Integer.valueOf(buttonTag) == 0){
        Leep.setCategory1(context, categoryEdit.getText().toString());
    }   else if(Integer.valueOf(buttonTag) == 1){
            Leep.setCategory2(context, categoryEdit.getText().toString());
        }else {
            Leep.setCategory3(context, categoryEdit.getText().toString());
        }

}}
