package edu.chl.leep.service;

import edu.chl.leep.model.LeepModel;

/**
 * Created by linneabark on 2017-08-20.
 */

public class UserInfoService {

    public boolean compareUserInfo(String userName, String passWord) {

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
        if(LeepModel.getKeepLoginState() == 0){
            LeepModel.checkUser(LeepModel.getPreviousUser());
            return true;
        }
        return false;
    }

    public void rememberUser(Boolean checked){
        LeepModel.setKeepLoginState(checked);
        LeepModel.setPreviousUser();
    }
}
