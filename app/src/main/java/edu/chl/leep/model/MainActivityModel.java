package edu.chl.leep.model;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Eli on 2017-05-24.
 */

public class MainActivityModel {

    public void logOutUser(Context mContext){
        Leep.setKeepLoginStateToZero(mContext, 0);
        Toast.makeText(mContext, ("Logged out " + Leep.getUsername(mContext)+"!"),Toast.LENGTH_SHORT).show();
    }

}
