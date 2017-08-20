package edu.chl.leep.model;


/**
 * Created by Eli on 2017-05-24.
 * A model class which contains some methods used in RegisterActivityController
 */

public class RegisterActivityModel { //TODO rename and move to utils

    public boolean comparePasswords(String password, String repeatPassword) {
        if (password.equals(repeatPassword)) {
            return true;
        }

        return false;
    }

    public boolean checkEmail(String mail){
        if((mail.contains("@")) && (mail.contains("."))){
            return true;

        }
        return false;

    }

}
