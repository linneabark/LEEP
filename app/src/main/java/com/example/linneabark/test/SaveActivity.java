package com.example.linneabark.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evelina on 2017-05-05.
 */

public class SaveActivity {
    public static List<ActivityRow> activityRowList = new ArrayList<>();

    public void addActivity (ActivityRow activityRow) {
        activityRowList.add(activityRow);
    }
}
