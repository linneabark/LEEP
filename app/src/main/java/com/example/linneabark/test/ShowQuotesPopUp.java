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

    public void showQuotesPopUpOne(final Context context, Activity activity) {

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder((activity));
        LayoutInflater inflater = activity.getLayoutInflater();
        View quotesLayout = inflater.inflate(R.layout.pop_up_quotes, null);
        helpBuilder.setView(quotesLayout);

        final AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();

        quotesEdit = (EditText) quotesLayout.findViewById(R.id.edit_text_quotes);
        quotesEdit.setText(Leep.getQuote1(context), TextView.BufferType.EDITABLE);

        saveButtonQuotes = (Button) quotesLayout.findViewById(R.id.save_button_quotes);
        saveButtonQuotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Leep.setQuote1(context, quotesEdit.getText().toString());
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

    public void showQuotesPopUpTwo(final Context context, Activity activity) {

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder((activity));
        LayoutInflater inflater = activity.getLayoutInflater();
        View quotesLayout = inflater.inflate(R.layout.pop_up_quotes, null);
        helpBuilder.setView(quotesLayout);

        final AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();

        quotesEdit = (EditText) quotesLayout.findViewById(R.id.edit_text_quotes);
        quotesEdit.setText(Leep.getQuote2(context), TextView.BufferType.EDITABLE);

        saveButtonQuotes = (Button) quotesLayout.findViewById(R.id.save_button_quotes);
        saveButtonQuotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Leep.setQuote2(context, quotesEdit.getText().toString());
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

    public void showQuotesPopUpThree(final Context context, Activity activity) {

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder((activity));
        LayoutInflater inflater = activity.getLayoutInflater();
        View quotesLayout = inflater.inflate(R.layout.pop_up_quotes, null);
        helpBuilder.setView(quotesLayout);

        final AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();

        quotesEdit = (EditText) quotesLayout.findViewById(R.id.edit_text_quotes);
        quotesEdit.setText(Leep.getQuote3(context), TextView.BufferType.EDITABLE);

        saveButtonQuotes = (Button) quotesLayout.findViewById(R.id.save_button_quotes);
        saveButtonQuotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Leep.setQuote3(context, quotesEdit.getText().toString());
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

}
