package com.example.linneabark.test;

import java.text.Format;

/**
 * Created by Evelina on 2017-05-06.
 */

public class FindWhichMonth {

    private SaveActivity saveActivity = new SaveActivity();

    private String findMonthNbr;

    //måste göra så att representerande månad i text motsvarar en siffra
    public String getNumberMonth (int i) {
        if (saveActivity.activityRowList.get(i).getMonth().equals("01")) {
            findMonthNbr = "01";
            return "Jan.";
        } else if (saveActivity.activityRowList.get(i).getMonth().equals("02")) {
            findMonthNbr = "02";
            return "Feb.";
        } else if (saveActivity.activityRowList.get(i).getMonth().equals("03")) {
            findMonthNbr = "03";
            return "Mar.";
        } else if (saveActivity.activityRowList.get(i).getMonth().equals("04")) {
            findMonthNbr = "04";
            return "Apr.";
        } else if (saveActivity.activityRowList.get(i).getMonth().equals("05")) {
            findMonthNbr = "05";
            return "May";
        } else if (saveActivity.activityRowList.get(i).getMonth().equals("06")) {
            findMonthNbr = "06";
            return "Jun.";
        } else if (saveActivity.activityRowList.get(i).getMonth().equals("07")) {
            findMonthNbr = "07";
            return "Jul.";
        } else if (saveActivity.activityRowList.get(i).getMonth().equals("08")) {
            findMonthNbr = "08";
            return "Aug.";
        } else if (saveActivity.activityRowList.get(i).getMonth().equals("09")) {
            findMonthNbr = "09";
            return "Sep.";
        } else if (saveActivity.activityRowList.get(i).getMonth().equals("10")) {
            findMonthNbr = "10";
            return "Oct.";
        } else if (saveActivity.activityRowList.get(i).getMonth().equals("11")) {
            findMonthNbr = "11";
            return "Nov.";
        } else if (saveActivity.activityRowList.get(i).getMonth().equals("12")) {
            findMonthNbr = "12";
            return "Dec.";
        }
        System.out.println("There is not a month that matches in the list with the number of a month.");
        return "Can not find a matching month in the list by number.";
    }
}
