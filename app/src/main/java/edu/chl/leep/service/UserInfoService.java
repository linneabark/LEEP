package edu.chl.leep.service;

import edu.chl.leep.ctrl.MainActivityController;
import edu.chl.leep.model.Category;
import edu.chl.leep.model.LeepModel;
import edu.chl.leep.model.Quote;
import edu.chl.leep.model.TimerModel;
import edu.chl.leep.utils.Contexts;

/**
 * Created by linneabark on 2017-08-20.
 */

public class UserInfoService {

    Category cat = new Category();
    Quote qt = new Quote();

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

    public void cleanTimer(){
        LeepModel.setKeepLoginStateToFalse();
        TimerModel time = TimerModel.getInstance((MainActivityController) Contexts.getContexts()); //TODO bort med ctrl
        time.stopTimer();
    }


    public void checkCategoryStatus() {
        if ((LeepModel.getCategory1().equals("")) && (LeepModel.getCategory2().equals(""))
                && (LeepModel.getCategory3().equals(""))) {

            LeepModel.setCategory1(cat.getCategory1());
            LeepModel.setCategory2(cat.getCategory2());
            LeepModel.setCategory3(cat.getCategory3());
        }
    }


    public void checkQuoteStatus(){
        if(((LeepModel.getQuote1()).equals("")) && ((LeepModel.getQuote2()).equals(""))
                && ((LeepModel.getQuote3()).equals(""))) {
            LeepModel.setQuote1(qt.getQuote1());
            LeepModel.setQuote2(qt.getQuote2());
            LeepModel.setQuote3(qt.getQuote3());
        }

    }
}
