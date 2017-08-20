package edu.chl.leep.utils;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.linneabark.test.R;

import edu.chl.leep.ctrl.MainActivityController;
import edu.chl.leep.ctrl.SettingsController;
import edu.chl.leep.ctrl.StatisticsController;
import edu.chl.leep.ctrl.TimeLogController;
import edu.chl.leep.model.MainActivityModel;

/**
 * Created by Eli on 2017-07-04.
 */

public class Fragments {

    static public FragmentManager fragmentManager; //TODO private?? den under med gäller alla instansvariabler i alla klasser
    static SettingsController settings;

    public static void setFragmentManager(FragmentManager fM){
        fragmentManager = fM;
    }

    public static boolean changeFragment(int id){ //kopplad till alla controllers, hur ändra?
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment nextFrag = new Fragment();
        settings = new SettingsController();

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
               MainActivityController mainActivityController = new MainActivityController();
                mainActivityController.logOut();

                //Hålla ett objekt av model elr inte? nedanför gör, ovanför inte
               /*MainActivityModel mainActivityModel = new MainActivityModel();
                mainActivityModel.logOutUser();
                Contexts.getContexts().startActivity(Intents.ToLogIn(Contexts.getContexts()));*/
               // Toast.makeText(Contexts.getContexts(), ("Logged out " + LeepModel.getUsername()+"!"),Toast.LENGTH_SHORT).show();



        }
        transaction.add(R.id.fragment_container, nextFrag);
        transaction.commit();
        return true;
    }

    public static void showPopUps(View v){
        settings.choosePopUp(v);
    }

}