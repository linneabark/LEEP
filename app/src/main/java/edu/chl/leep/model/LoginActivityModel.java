package edu.chl.leep.model;

/**
 * Created by Eli on 2017-05-24.
 A model class which contains some methods used in LoginActivityController*/

public class LoginActivityModel {


    public boolean compareUserInfo(String userName, String passWord) {

        LeepModel.setUSER(userName);
        if(userName.equals("") || passWord.equals("")){
            return false;
        }
        if ((userName.equals(LeepModel.getUsername())) &&
                (passWord.equals(LeepModel.getPassword()))) {
            return true;
        }
        return false;
    }

    public boolean userWasLoggedIn(){
        if(LeepModel.getKeepLoginState() == true){
            LeepModel.setUSER(LeepModel.getPreviousUser());
            return true;
        }
        return false;
    }

    public void rememberUser(Boolean checked){
        LeepModel.setKeepLoginState(checked);
        LeepModel.setPreviousUser(LeepModel.getUSER());
    }


}
