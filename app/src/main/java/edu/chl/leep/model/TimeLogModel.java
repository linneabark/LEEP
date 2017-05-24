package edu.chl.leep.model;

import java.util.Calendar;

/**
 * Created by Eli on 2017-05-24.
 */

public class TimeLogModel {

    private Calendar cal = Calendar.getInstance();

    public int getHour(){

        int hour = cal.get(Calendar.HOUR);


        return hour;
    }

    public int getMinute(){
        int minute = cal.get(Calendar.MINUTE);
        return minute;
    }
}
