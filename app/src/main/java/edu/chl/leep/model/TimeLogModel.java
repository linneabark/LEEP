package edu.chl.leep.model;

import android.content.Context;

import java.util.Calendar;

/**
 * Created by Eli on 2017-05-24.
 */

public class TimeLogModel {

    private String quote1 = "Quote 1";
    private String quote2 = "Quote 2";
    private String quote3 = "Quote 3";

    private Calendar cal = Calendar.getInstance();

    public int getHour(){

        int hour = cal.get(Calendar.HOUR);


        return hour;
    }

    public int getMinute(){
        int minute = cal.get(Calendar.MINUTE);
        return minute;
    }

    public void checkQuoteStatus(Context mcontext){
        if(((Leep.getQuote1(mcontext)).equals("")) && ((Leep.getQuote2(mcontext)).equals(""))
                && ((Leep.getQuote3(mcontext)).equals(""))) {
            Leep.setQuote1(mcontext, quote1);
            Leep.setQuote2(mcontext, quote2);
            Leep.setQuote3(mcontext, quote3);
        }
    }
}
