package com.example.linneabark.test;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Eli on 2017-05-03.
 */

public class SaveDate {
    private final static long MILLIS_TO_MINUTES = 60000;
    private final static long MILLIS_TO_HOURS = 3600000;
    Date date = new Date();

    public SaveDate(){
    }

    public String calculateTimeToString(long curTimeMillis){
        long curTime = curTimeMillis;

        int seconds = (int) ((curTime / 1000) % 60);
        int minutes = (int) ((curTime / MILLIS_TO_MINUTES) % 60);
        int hours = (int) ((curTime / MILLIS_TO_HOURS) % 24);

        String str = String.format("%02d:%02d:%02d", hours, minutes, seconds);

        return str;
    }

    public String calculateDateToString(Date date){
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");

        String str = formatter.format(date);

        return str;
    }

    public String calculateYearToString(){
        DateFormat dateFormatYear = new SimpleDateFormat("yyyy");

        return dateFormatYear.format(date);
    }

    public String calculateMonthToString(){
        DateFormat dateFormatMonth = new SimpleDateFormat("MM");

        return dateFormatMonth.format(date);
    }

    public String calculateDayToString(){
        DateFormat dateFormatDay = new SimpleDateFormat("dd");

        return dateFormatDay.format(date);
    }
}

