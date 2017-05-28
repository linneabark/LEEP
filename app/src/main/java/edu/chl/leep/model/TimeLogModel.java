package edu.chl.leep.model;

import android.content.Context;

import java.util.Calendar;

/**
 * Created by Eli on 2017-05-24.
 A model class which contains some methods used in TimeLogController*/

public class TimeLogModel {

    private String quote1 = "Quote 1";
    private String quote2 = "Quote 2";
    private String quote3 = "Quote 3";

    private Calendar cal = Calendar.getInstance();

    private String category1 = "Category 1";
    private String category2 = "Category 2";
    private String category3 = "Category 3";

    public void checkCategoryStatus(Context mContext) {

        if ((LeepModel.getCategory1(mContext).equals("")) && (LeepModel.getCategory2(mContext).equals(""))
                && (LeepModel.getCategory3(mContext).equals(""))) {

            LeepModel.setCategory1(mContext, category1);
            LeepModel.setCategory2(mContext, category2);
            LeepModel.setCategory3(mContext, category3);
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

    public void checkQuoteStatus(Context mcontext){
        if(((LeepModel.getQuote1(mcontext)).equals("")) && ((LeepModel.getQuote2(mcontext)).equals(""))
                && ((LeepModel.getQuote3(mcontext)).equals(""))) {
            LeepModel.setQuote1(mcontext, quote1);
            LeepModel.setQuote2(mcontext, quote2);
            LeepModel.setQuote3(mcontext, quote3);
        }

}}

