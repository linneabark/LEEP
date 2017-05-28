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
            return Leep.getQuote1(context);
        }else if (Integer.valueOf(buttontag) == 1){
            return Leep.getQuote2(context);
        }else{
            return Leep.getQuote3(context);
        }
    }

    private void setQuote(Context context, String buttonTag){
        if (Integer.valueOf(buttonTag) == 0){
            Leep.setQuote1(context, quotesEdit.getText().toString());
        }   else if(Integer.valueOf(buttonTag) == 1){
            Leep.setQuote2(context, quotesEdit.getText().toString());
        }else {
            Leep.setQuote3(context, quotesEdit.getText().toString());
        }
    }
}
