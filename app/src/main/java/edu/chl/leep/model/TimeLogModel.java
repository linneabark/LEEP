package edu.chl.leep.model;

import java.util.Calendar;

/**
 * Created by Eli on 2017-05-24.
 * A model class which contains some methods used in TimeLogController
 * */

public class TimeLogModel {

    private String quote1 = "Quote 1";
    private String quote2 = "Quote 2";
    private String quote3 = "Quote 3";

    private Calendar cal = Calendar.getInstance();

    private String category1 = "Category 1";
    private String category2 = "Category 2";
    private String category3 = "Category 3";

    public void checkCategoryStatus() {

        if ((LeepModel.getCategory1().equals("")) && (LeepModel.getCategory2().equals(""))
                && (LeepModel.getCategory3().equals(""))) {

            LeepModel.setCategory1(category1);
            LeepModel.setCategory2( category2);
            LeepModel.setCategory3( category3);
        }
    }

    public int getHour() {
        int hour = cal.get(Calendar.HOUR);
        return hour;
    }

    public int getMinute() {
        int minute = cal.get(Calendar.MINUTE);
        return minute;
    }

    public void checkQuoteStatus(){
        if(((LeepModel.getQuote1()).equals("")) && ((LeepModel.getQuote2()).equals(""))
                && ((LeepModel.getQuote3()).equals(""))) {
            LeepModel.setQuote1( quote1);
            LeepModel.setQuote2( quote2);
            LeepModel.setQuote3( quote3);
        }

}}

