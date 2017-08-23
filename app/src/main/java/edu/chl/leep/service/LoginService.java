package edu.chl.leep.service;

/**
 * Created by linneabark on 2017-08-22.
 */

public class LoginService {

    public boolean compareUserInfo(String userName, String passWord, String SPUserName, String SPPassword) { //TODO skicka in leepModel från ctrl, via parameterna

        if(userName.equals("") || passWord.equals("")){
            return false;
        }
        if ((userName.equals(SPUserName)) &&
                (passWord.equals(SPPassword))) {
            return true;
        }
        return false;
    }
}
