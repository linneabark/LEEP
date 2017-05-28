package com.example.linneabark.test;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import edu.chl.leep.model.ActivityRow;
import edu.chl.leep.model.Leep;
import edu.chl.leep.service.SaveActivity;

/**
 * Created by Evelinas on 2017-05-27.
 */

public class SaveActivityRowList {

    //For save
    public static void saveActivityRowListSharedPref (Context context, List<ActivityRow> saveSharedList) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Leep.getUSER(), context.MODE_PRIVATE);
        SharedPreferences.Editor sharedPrefEditor = sharedPreferences.edit();

        Gson gson = new Gson();

        String json = gson.toJson(saveSharedList);
        sharedPrefEditor.putString("myJson", json);
        sharedPrefEditor.commit();

    }

    //For load
    private static List<ActivityRow> loadSharedList;

    private static List<ActivityRow> loadActivityRowListSharedPref(Context context) {
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

    public static void putTheValuesInActivityRowList (Context context) {
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

}
