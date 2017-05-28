package edu.chl.leep.model;

import android.content.Context;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Eli on 2017-05-24.
 A model class which contains some methods used in LoginActivityController*/

public class LoginActivityModel {

    public boolean compareUserInfo(Context mContext, EditText userName, EditText passWord) {

        LeepModel.setUSER(userName.getText().toString());
        if(userName.getText().toString().equals("") || passWord.getText().toString().equals("")){
            return false;
        }
        if ((userName.getText().toString().equals(LeepModel.getUsername(mContext))) && (passWord.getText().toString().equals(LeepModel.getPassword(mContext)))) {
            return true;
        }
        return false;
    }

    public boolean userWasLoggedIn(Context mContext){
        if(LeepModel.getKeepLoginState(mContext) == 1){
            LeepModel.setUSER(LeepModel.getPreviousUser(mContext));
            return true;
        }
        return false;
    }

    public void rememberUser(Context mContext, RadioButton rB){

        LeepModel.setKeepLoginState(mContext, rB);//see whether or not the radiobutton is checked(1 = true, 0 = false)
        LeepModel.setPreviousUser(mContext, LeepModel.getUSER());

        Toast.makeText(mContext, ("Logged in " + LeepModel.getUsername(mContext) + "!"), Toast.LENGTH_SHORT).show();
    }
}
