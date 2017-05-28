package edu.chl.leep.service;

import edu.chl.leep.model.ActivityRowModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evelina on 2017-05-05.
 */

public class SaveActivity {

    public static List<ActivityRowModel> activityRowList = new ArrayList<>();

    public static void addActivity (ActivityRowModel activityRow) {
        activityRowList.add(activityRow);
    }
}