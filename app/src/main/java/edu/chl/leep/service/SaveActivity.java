package edu.chl.leep.service;

import edu.chl.leep.model.ActivityRow;

import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evelina on 2017-05-05.
 */

public class SaveActivity {

    //TODO Slå ihop med fileservice

    public static List<ActivityRow> activityRowList = new ArrayList<>();

    public static void addActivity (ActivityRow activityRow) {
        activityRowList.add(activityRow);
    }
}