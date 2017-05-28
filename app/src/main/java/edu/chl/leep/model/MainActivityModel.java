package edu.chl.leep.model;

import android.content.Context;
import android.widget.Toast;

import edu.chl.leep.ctrl.MainActivityController;

/**
 * Created by Eli on 2017-05-24.
 A model class which contains some methods used in MainActivityController*/

public class MainActivityModel {

    public void logOutUser(Context mContext){
        LeepModel.setKeepLoginStateToZero(mContext, 0);
        TimeModel time = TimeModel.getInstance((MainActivityController)mContext);
        time.stopTimer();
        Toast.makeText(mContext, ("Logged out " + LeepModel.getUsername(mContext)+"!"),Toast.LENGTH_SHORT).show();
    }

}
