package edu.chl.leep.service;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import edu.chl.leep.model.ActivityRowModel;
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
    private static List<ActivityRowModel> loadSharedList;

    //For save
    public void saveActivityRowListSharedPref (Context context, List<ActivityRowModel> saveSharedList) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(LeepModel.getUSER(), Context.MODE_PRIVATE);
        SharedPreferences.Editor sharedPrefEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(saveSharedList);
        sharedPrefEditor.putString("myJson", json);
        sharedPrefEditor.commit();

    }

    //For load
    private List<ActivityRowModel> loadActivityRowListSharedPref(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(LeepModel.getUSER(), Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("myJson", "");
        if (json.isEmpty()) {
            loadSharedList = new ArrayList<>();
        } else {
            Type type = new TypeToken<List<ActivityRowModel>>() {}.getType();
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

    public static SharedPreferences getPrefPreviousUser(Context context) {
        return context.getSharedPreferences("previousUser", Context.MODE_PRIVATE);
    }


}
