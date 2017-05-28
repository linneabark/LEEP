package edu.chl.leep.model;

import android.content.Context;
import android.widget.Toast;

import edu.chl.leep.ctrl.MainActivity;

/**
 * Created by Eli on 2017-05-24.
 A model class which contains some methods used in MainActivity*/

public class MainActivityModel {

    public void logOutUser(Context mContext){
        Leep.setKeepLoginStateToZero(mContext, 0);
        Time time = Time.getInstance((MainActivity)mContext);
        time.stopTimer();
        Toast.makeText(mContext, ("Logged out " + Leep.getUsername(mContext)+"!"),Toast.LENGTH_SHORT).show();
    }

}
