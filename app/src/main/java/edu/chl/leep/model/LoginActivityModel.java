package edu.chl.leep.model;

import android.content.Context;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Eli on 2017-05-24.
 A model class which contains some methods used in LoginActivity*/

public class LoginActivityModel {

    public boolean compareUserInfo(Context mContext, EditText userName, EditText passWord) {

        Leep.setUSER(userName.getText().toString());
        if(userName.getText().toString().equals("") || passWord.getText().toString().equals("")){
            return false;
        }
        if ((userName.getText().toString().equals(Leep.getUsername(mContext))) && (passWord.getText().toString().equals(Leep.getPassword(mContext)))) {
            return true;
        }
        return false;
    }

    public boolean userWasLoggedIn(Context mContext){
        if(Leep.getKeepLoginState(mContext) == 1){
            Leep.setUSER(Leep.getPreviousUser(mContext));
            return true;
        }
        return false;
    }

    public void rememberUser(Context mContext, RadioButton rB){

        Leep.setKeepLoginState(mContext, rB);//see whether or not the radiobutton is checked(1 = true, 0 = false)
        Leep.setPreviousUser(mContext, Leep.getUSER());

        Toast.makeText(mContext, ("Logged in " + Leep.getUsername(mContext) + "!"), Toast.LENGTH_SHORT).show();
    }
}
