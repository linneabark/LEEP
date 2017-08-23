package edu.chl.leep.service;

import edu.chl.leep.model.ActivityObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evelina on 2017-05-05.
 *
 *  A class which contains the list of the activities and a method to add an activity
 */

public class SaveActivityService {

    public static List<ActivityObject> activityRowList = new ArrayList<>();

    public static void addActivity (ActivityObject activityRow) {
        activityRowList.add(activityRow);
    }
}