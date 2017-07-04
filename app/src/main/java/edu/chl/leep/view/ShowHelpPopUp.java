package edu.chl.leep.view;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.linneabark.test.R;

/**
 * Created by linneabark on 2017-05-28.
 *
* Class that which shows "help"-popup
 */

public class ShowHelpPopUp {

    public void showHelpPopUp(Activity activity) {

        final AlertDialog.Builder helpBuilder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        final View helpLayout = inflater.inflate(R.layout.pop_up_help, null);
        helpBuilder.setView(helpLayout);

        final AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
        Button exitButtonHelp = (Button) helpLayout.findViewById(R.id.done_button_help);
        exitButtonHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helpDialog.dismiss();
            }
        });
    }
}
