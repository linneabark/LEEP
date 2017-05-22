package edu.chl.leep.service;

import edu.chl.leep.model.ActivityRow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evelina on 2017-05-05.
 */

public class SaveActivity {

    //TODO Slå ihop med fileservice

    public static List<ActivityRow> activityRowList = new ArrayList<>();



    public void addActivity (ActivityRow activityRow) {
        activityRowList.add(activityRow);
    }


    }

