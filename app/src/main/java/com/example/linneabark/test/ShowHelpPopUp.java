package com.example.linneabark.test;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

/**
 * Created by linneabark on 2017-05-28.
 *
* Class that which shows "help"-popup
 */

public class ShowHelpPopUp {

    private Button exitButtonHelp;

    public void showHelpPopUp(Activity activity) {

        final AlertDialog.Builder helpBuilder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        final View helpLayout = inflater.inflate(R.layout.pop_up_help, null);
        helpBuilder.setView(helpLayout);

        final AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
        exitButtonHelp = (Button) helpLayout.findViewById(R.id.done_button_help);
        exitButtonHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helpDialog.dismiss();
            }
        });
    }
}
