package com.example.linneabark.test;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.linneabark.test.Chronometer.MILLIS_TO_HOURS;
import static com.example.linneabark.test.Chronometer.MILLIS_TO_MINUTES;

/**
 * Created by Eli on 2017-05-03.
 */

public class SaveDate {

    public SaveDate(){
    }

    final static long MILLIS_TO_MINUTES = 60000;
    final static long MILLIS_TO_HOURS = 3600000;

    public static String calculateTimeToString(long curTimeMillis){

        long curTime = curTimeMillis;

        int seconds = (int) ((curTime / 1000) % 60);
        int minutes = (int) ((curTime / MILLIS_TO_MINUTES) % 60);
        int hours = (int) ((curTime / MILLIS_TO_HOURS) % 24);

        String str = String.format("%02d:%02d:%02d", hours, minutes, seconds);

        return str;

    }

    public static String calculateDateToString(Date date){

        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = formatter.format(date);

        return str;


    }

    }

