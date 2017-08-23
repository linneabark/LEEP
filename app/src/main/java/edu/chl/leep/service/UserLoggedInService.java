package edu.chl.leep.service;

import android.content.SharedPreferences;
import edu.chl.leep.utils.Contexts;

/**
 * Created by linneabark on 2017-08-22.
 */

public class UserLoggedInService {

    private static SharedPreferences getKeepLoggedIn() { //or is it getPrefs?
        return Contexts.getContexts().getSharedPreferences("LoggedInState", Contexts.getContexts().MODE_PRIVATE);
    }


    //keeps track of wether or not the user is already logged in or not
    public static void setKeepLoginStateToFalse(){
        SharedPreferences.Editor editor = getKeepLoggedIn().edit();

        editor.putInt("RadioButton", 1);
        editor.apply();
    }

    public static void setKeepLoginState(boolean input) {

        SharedPreferences.Editor editor = getKeepLoggedIn().edit();
        if (input) {
            editor.putInt("RadioButton", 0);
            editor.apply();
        }if(!input) {
            editor.putInt("RadioButton", 1);
            editor.apply();
        }
    }

    public static int getKeepLoginState() {
        return getKeepLoggedIn().getInt("RadioButton", 0);
    }

}
