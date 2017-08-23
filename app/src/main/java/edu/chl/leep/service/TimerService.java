package edu.chl.leep.service;

import edu.chl.leep.ctrl.MainActivityController;
import edu.chl.leep.model.TimerModel;
import edu.chl.leep.utils.Contexts;

/**
 * Created by linneabark on 2017-08-22.
 */

public class TimerService {

    public void cleanTimer(){
        //UserLoggedInService.setKeepLoginStateToFalse();
        TimerModel time = TimerModel.getInstance((MainActivityController) Contexts.getContexts()); //TODO bort med ctrl
        time.stopTimer();
    }
}
