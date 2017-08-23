package edu.chl.leep.service;

/**
 * Created by linneabark on 2017-08-22.
 */

public class RegisterService {

    public boolean comparePasswords(String password, String repeatPassword) { //TODO utils
        if (password.equals(repeatPassword)) {
            return true;
        }
        return false;
    }

    public boolean checkEmail(String mail){ //TODO utils
        if((mail.contains("@")) && (mail.contains("."))){
            return true;

        }
        return false;

    }
}
