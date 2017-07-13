package edu.chl.leep.model;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import edu.chl.leep.utils.Contexts;

/**
 * Created by Eli on 2017-05-24.
 A model class which contains some methods used in LoginActivityController*/

public class LoginActivityModel {


    public boolean compareUserInfo(EditText userName, EditText passWord) {

        LeepModel.setUSER(userName.getText().toString());
        if(userName.getText().toString().equals("") || passWord.getText().toString().equals("")){
            return false;
        }
        if ((userName.getText().toString().equals(LeepModel.getUsername())) &&
                (passWord.getText().toString().equals(LeepModel.getPassword()))) {
            return true;
        }
        return false;
    }

    public boolean userWasLoggedIn(){
        if(LeepModel.getKeepLoginState() == 1){
            LeepModel.setUSER(LeepModel.getPreviousUser());
            return true;
        }
        return false;
    }

    public void rememberUser(RadioButton rB){
        LeepModel.setKeepLoginState(rB);
        LeepModel.setPreviousUser(LeepModel.getUSER());

        Toast.makeText(Contexts.getContexts(), ("Logged in " + LeepModel.getUsername() + "!"), Toast.LENGTH_SHORT).show();
    }
}
