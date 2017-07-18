package edu.chl.leep.model;

import edu.chl.leep.ctrl.MainActivityController;
import edu.chl.leep.utils.Contexts;


/**
 * Created by Eli on 2017-05-24.
 A model class which contains some methods used in MainActivityController*/

public class MainActivityModel {

    public void logOutUser(){
        LeepModel.setKeepLoginStateToZero( 0);
        TimerModel time = TimerModel.getInstance((MainActivityController) Contexts.getContexts());
        time.stopTimer();
    }

}
