package com.example.linneabark.test;

import android.app.ActionBar;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

/**
 * Created by linneabark on 2017-05-09.
 */

public class PopUpWindow extends Activity {

    //Button showPopUpButton = (Button) findViewById(R.layout.);

    public void onCreate (Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);

    }

    public void onClick(View v){
        showSimplePopUp();

    }

    private void showSimplePopUp (){
        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);
        helpBuilder.setTitle("Pop Up");
        helpBuilder.setMessage("This is a simple Pop Up");
        helpBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
            public void onClick (DialogInterface dialog, int wich){
                //Do nothing but close the dialog
            }
        }) ;
        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
    }

}
