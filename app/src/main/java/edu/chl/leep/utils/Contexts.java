package edu.chl.leep.utils;

import android.content.Context;

/**
 * Created by Eli on 2017-07-13.
 */

public class Contexts { //TODO change name (Resource locator) do we even need this används inte i model?

    static Context context;


    public static Context getContexts(){

        return context;

    }

    public static void setContexts(Context mContext){
        context = mContext;
    }
}
