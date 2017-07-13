package edu.chl.leep.utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.linneabark.test.R;

import edu.chl.leep.ctrl.MainActivityController;
import edu.chl.leep.ctrl.SettingsController;
import edu.chl.leep.ctrl.StatisticsController;
import edu.chl.leep.ctrl.TimeLogController;

/**
 * Created by Eli on 2017-07-04.
 */

public class Fragments extends MainActivityController {

    private SettingsController settings;
    Context mContext;


    /*public boolean changeFragment(int id){ //kopplad till alla controllers, hur ändra?
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment nextFrag = new Fragment();
        settings = new SettingsController();
        mContext = this.getContext();

        switch (id) {
            case R.id.settings_id:
                nextFrag = settings;
                break;
            case R.id.statistics_id:
                nextFrag = new StatisticsController();
                break;
            case R.id.timelog_id:
                nextFrag = new TimeLogController();
                break;
            case R.id.account_id:
                //mainActivityModel.logOutUser(mContext);
                startActivity(Intents.ToLogIn(mContext));


        }
        transaction.add(R.id.fragment_container, nextFrag);
        transaction.commit();
        return true;
    }*/
}
