package edu.chl.leep.service;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import edu.chl.leep.model.ActivityRow;
import edu.chl.leep.model.Leep;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Eli on 2017-05-15.
 */

public class FileService implements Serializable {
    //For load
    private static List<ActivityRow> loadSharedList;

    //For save
    public void saveActivityRowListSharedPref (Context context, List<ActivityRow> saveSharedList) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Leep.getUSER(), context.MODE_PRIVATE);
        SharedPreferences.Editor sharedPrefEditor = sharedPreferences.edit();

        Gson gson = new Gson();

        String json = gson.toJson(saveSharedList);
        sharedPrefEditor.putString("myJson", json);
        sharedPrefEditor.commit();

    }


    //For load
    private List<ActivityRow> loadActivityRowListSharedPref(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Leep.getUSER(), context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("myJson", "");
        if (json.isEmpty()) {
            loadSharedList = new ArrayList<>();
        } else {
            Type type = new TypeToken<List<ActivityRow>>() {}.getType();
            loadSharedList = gson.fromJson(json, type);
        }
        return loadSharedList;
    }

    //For load
    public void putTheValuesInActivityRowList (Context context) {
        System.out.println("Klass SaveActivityRowList, metod putTheValuesInActivityRowList.");
        loadActivityRowListSharedPref(context);

        for (int i = 0; i < loadSharedList.size(); i++) {
            System.out.println("Klass SaveActivityRowList, metod putTheValuesInActivityRowList. " +
                    "loadSharedList ('the loaded list') contains: " + loadSharedList.get(i).getUserName() +  " " + loadSharedList.get(i).getStartTime());
            SaveActivity.addActivity(loadSharedList.get(i));
            System.out.println("Klass SaveActivityRowList, metod putTheValuesInActivityRowList. " +
                    "ActivityRowlist ('the main list') contains: " + SaveActivity.activityRowList.get(i).getUserName() +  " " + SaveActivity.activityRowList.get(i).getStartTime());
        }
    }



    /*spara user info som en lista i en textfil
    användarnamn
    lösenord
    email

    openSavedActivities() kommer skicka in användarnamnet som filnamn,
    och därefter skapa en fil med aktiviteterna till det användarnamnet
     */

    //Flyttades hit pga Hacht
    public static SharedPreferences getPrefPreviousUser(Context context) { //or is it getPrefs?
        //TODO flytta till fileservice, allt som har med att skriva ut

        return context.getSharedPreferences("previousUser", Context.MODE_PRIVATE);
    }


}
