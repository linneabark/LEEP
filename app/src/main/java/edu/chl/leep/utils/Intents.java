package edu.chl.leep.utils;

import android.content.Context;
import android.content.Intent;

import edu.chl.leep.ctrl.LoginActivityController;
import edu.chl.leep.ctrl.MainActivityController;
import edu.chl.leep.ctrl.RegisterActivityController;

/**
 * Created by Eli on 2017-07-04.
 *
 * A class to change between Activities
 */

public class Intents {

    public static final String FIRST_NAME = "first_name";

    public static Intent ToMain(Context ctx) {
        Intent intent = new Intent(ctx, MainActivityController.class);
        //intent.putExtra(FIRST_NAME, firstName);
        return intent;
    }

    public static Intent ToLogIn(Context ctx) {
        Intent intent = new Intent(ctx, LoginActivityController.class);
        //intent.putExtra(FIRST_NAME, firstName);
        return intent;
    }

    public static Intent ToRegister(Context ctx) {
        Intent intent = new Intent(ctx, RegisterActivityController.class);
        //intent.putExtra(FIRST_NAME, firstName);
        return intent;
    }
}
