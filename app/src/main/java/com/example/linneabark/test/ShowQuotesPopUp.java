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
 * Class that decidecs which shows "quotes"-popup to show
 */

public class ShowQuotesPopUp {

    private Button saveButtonQuotes;
    private Button exitButtonQuotes;
    private EditText quotesEdit;

    public void showQuotesPopUp(final Context context, Activity activity, final String buttonTag) {

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder((activity));
        LayoutInflater inflater = activity.getLayoutInflater();
        View quotesLayout = inflater.inflate(R.layout.pop_up_quotes, null);
        helpBuilder.setView(quotesLayout);
        final AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();

        quotesEdit = (EditText) quotesLayout.findViewById(R.id.edit_text_quotes);
        quotesEdit.setText(getQuote(buttonTag, context), TextView.BufferType.EDITABLE);

        saveButtonQuotes = (Button) quotesLayout.findViewById(R.id.save_button_quotes);
        saveButtonQuotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setQuote(context, buttonTag);
                helpDialog.dismiss();
            }
        });
        exitButtonQuotes = (Button) quotesLayout.findViewById(R.id.close_button_quotes);
        exitButtonQuotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helpDialog.dismiss();
            }
        });
    }

    private String getQuote(String buttontag, Context context){
        if (Integer.valueOf(buttontag) == 0){
            return LeepModel.getQuote1(context);
        }else if (Integer.valueOf(buttontag) == 1){
            return LeepModel.getQuote2(context);
        }else{
            return LeepModel.getQuote3(context);
        }
    }

    private void setQuote(Context context, String buttonTag){
        if (Integer.valueOf(buttonTag) == 0){
            LeepModel.setQuote1(context, quotesEdit.getText().toString());
        }   else if(Integer.valueOf(buttonTag) == 1){
            LeepModel.setQuote2(context, quotesEdit.getText().toString());
        }else {
            LeepModel.setQuote3(context, quotesEdit.getText().toString());
        }
    }
}
