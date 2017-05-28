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

    public void showCategoryPopUpOne (final Context context, Activity activity) {
        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        View categoryLayout = inflater.inflate(R.layout.pop_up_category, null);
        helpBuilder.setView(categoryLayout);

        final AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();

        categoryEdit = (EditText) categoryLayout.findViewById(R.id.edit_text_category);
        categoryEdit.setText(Leep.getCategory1(context), TextView.BufferType.EDITABLE);

        saveButtonCategory = (Button) categoryLayout.findViewById(R.id.save_button_category);
        saveButtonCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Leep.setCategory1(context, categoryEdit.getText().toString());
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
    public void showCategoryPopUpTwo(final Context context, Activity activity){

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        View categoryLayout = inflater.inflate(R.layout.pop_up_category, null);
        helpBuilder.setView(categoryLayout);

        final AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();

        categoryEdit = (EditText) categoryLayout.findViewById(R.id.edit_text_category);
        categoryEdit.setText(Leep.getCategory2(context), TextView.BufferType.EDITABLE);

        saveButtonCategory = (Button) categoryLayout.findViewById(R.id.save_button_category);
        saveButtonCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Leep.setCategory2(context, categoryEdit.getText().toString());
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

    public void showCategoryPopUpThree(final Context context, Activity activity){

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        View categoryLayout = inflater.inflate(R.layout.pop_up_category, null);
        helpBuilder.setView(categoryLayout);

        final AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();

        categoryEdit = (EditText) categoryLayout.findViewById(R.id.edit_text_category);
        categoryEdit.setText(Leep.getCategory3(context), TextView.BufferType.EDITABLE);

        saveButtonCategory = (Button) categoryLayout.findViewById(R.id.save_button_category);
        saveButtonCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Leep.setCategory3(context, categoryEdit.getText().toString());
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
}
