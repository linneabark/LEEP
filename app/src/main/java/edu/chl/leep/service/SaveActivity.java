package edu.chl.leep.service;

import edu.chl.leep.model.ActivityRowModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evelina on 2017-05-05.
 *
 *  A class which contains the list of the activities and a method to add an activity
 */

public class SaveActivity {

    public static List<ActivityRowModel> activityRowList = new ArrayList<>();

    public static void addActivity (ActivityRowModel activityRow) {
        activityRowList.add(activityRow);
    }
}