package edu.chl.leep.utils;

import android.content.Context;

/**
 * Created by Eli on 2017-07-13.
 */

public class Contexts {

    static Context context;


    public static Context getContexts(){

        return context;

    }

    public static void setContexts(Context mContext){
        context = mContext;
    }
}
