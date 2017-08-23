package edu.chl.leep.service;
import edu.chl.leep.model.LeepModel;

/**
 * Created by linneabark on 2017-08-20.
 */

public class UserStateService { //TODO change name

    public boolean userWasLoggedIn(){
        if(UserLoggedInService.getKeepLoginState() == 0){
            LeepModel.checkUser(LeepModel.getPreviousUser());
            return true;
        }
        return false;
    }

    public void rememberUser(Boolean checked){
        UserLoggedInService.setKeepLoginState(checked);
        LeepModel.setPreviousUser();
    }
}
