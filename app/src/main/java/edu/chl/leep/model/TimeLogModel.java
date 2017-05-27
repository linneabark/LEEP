package edu.chl.leep.model;

import android.content.Context;

import java.util.Calendar;

import edu.chl.leep.ctrl.MainActivity;
import edu.chl.leep.ctrl.TimeLog;

/**
 * Created by Eli on 2017-05-24.
 */

public class TimeLogModel {

    private Calendar cal = Calendar.getInstance();

    private String category1 = "Category 1";
    private String category2 = "Category 2";
    private String category3 = "Category 3";

    TimeLog tL = new TimeLog();

    public void checkCategoryStatus(Context mContext) {

        if ((Leep.getCategory1(mContext).equals("")) && (Leep.getCategory2(mContext).equals(""))
                && (Leep.getCategory3(mContext).equals(""))) {

            Leep.setCategory1(mContext, category1);
            Leep.setCategory2(mContext, category2);
            Leep.setCategory3(mContext, category3);
        }
    }

    public boolean timeIs24() {
        long curTime = System.currentTimeMillis();

        if (curTime <= 86400000) {
            return true;
        }
        return false;
    }

    public int getHour() {

        int hour = cal.get(Calendar.HOUR);


        return hour;
    }

    public int getMinute() {
        int minute = cal.get(Calendar.MINUTE);
        return minute;
    }

}
