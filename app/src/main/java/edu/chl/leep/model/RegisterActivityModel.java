package edu.chl.leep.model;

import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Eli on 2017-05-24.
 A model class which contains some methods used in RegisterActivityController*/

public class RegisterActivityModel {

    public boolean comparePasswords(EditText password, EditText repeatPassword, TextView errorMessage) { //compares passwords before saving them (compares the two edittext-fields
        if (password.getText().toString().equals(repeatPassword.getText().toString())) {
            return true;
        }
        errorMessage.setText("Passwords does not match!");
        return false;
    }

    public boolean checkEmail(EditText mail, TextView errorMessage){ //checks the email in the edittext-field
        if((mail.getText().toString().contains("@")) && (mail.getText().toString().contains("."))){
            return true;

        }
        errorMessage.setText("Not a valid email!");
        return false;

    }
}
