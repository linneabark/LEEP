package edu.chl.leep.service;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import edu.chl.leep.model.ActivityObject;
import edu.chl.leep.model.LeepModel;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Evelina on 2017-05-28.
 *
 *  A class which stores and load list with SharedPreferences so that the activities can be retrieved after the program where being closed
 */

public class FileService implements Serializable {
    //For load
    private static List<ActivityObject> loadSharedList;

    //For save
    public void saveActivityRowListSharedPref (Context context, List<ActivityObject> saveSharedList) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(LeepModel.getUSER().getLogin(), Context.MODE_PRIVATE);
        SharedPreferences.Editor sharedPrefEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(saveSharedList);
        sharedPrefEditor.putString("myJson", json);
        sharedPrefEditor.commit();

    }

    //For load
    private List<ActivityObject> loadActivityRowListSharedPref(Context context) {
        if (LeepModel.getUSER() == null){
            System.out.println("get user i leep model är null");
            return loadSharedList = new ArrayList<>();
        } else {
            SharedPreferences sharedPreferences = context.getSharedPreferences(LeepModel.getUSER().getLogin(), Context.MODE_PRIVATE);
            Gson gson = new Gson();
            String json = sharedPreferences.getString("myJson", "");
            if (json.isEmpty()) {
                loadSharedList = new ArrayList<>();
            } else {
                Type type = new TypeToken<List<ActivityObject>>() {
                }.getType();
                loadSharedList = gson.fromJson(json, type);
            }
            return loadSharedList;
        }
    }

    //For load
    public void putTheValuesInActivityRowList (Context context) {
        loadActivityRowListSharedPref(context);

        for (int i = 0; i < loadSharedList.size(); i++) {
            SaveActivity.addActivity(loadSharedList.get(i));
        }
    }



}
