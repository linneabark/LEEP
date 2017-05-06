package com.example.linneabark.test;

/**
 * Created by Evelina on 2017-05-06.
 */

public class FindWhichMonth {

    private SaveActivity saveActivity = new SaveActivity();

    //måste göra så att representerande månad i text motsvarar en siffra
    public String getNumberMonth (int i) {
        if (saveActivity.activityRowList.get(i).getMonth().equals(01)) {
            return "Jan.";
        } else if (saveActivity.activityRowList.get(i).getMonth().equals(02)) {
            return "Feb.";
        } else if (saveActivity.activityRowList.get(i).getMonth().equals(03)) {
            return "Mar.";
        } else if (saveActivity.activityRowList.get(i).getMonth().equals(04)) {
            return "Apr.";
        } else if (saveActivity.activityRowList.get(i).getMonth().equals(05)) {
            return "May";
        } else if (saveActivity.activityRowList.get(i).getMonth().equals(06)) {
            return "Jun.";
        } else if (saveActivity.activityRowList.get(i).getMonth().equals(07)) {
            return "Jul.";
        } else if (saveActivity.activityRowList.get(i).getMonth().equals(08)) {
            return "Aug.";
        } else if (saveActivity.activityRowList.get(i).getMonth().equals(09)) {
            return "Sep.";
        } else if (saveActivity.activityRowList.get(i).getMonth().equals(10)) {
            return "Oct.";
        } else if (saveActivity.activityRowList.get(i).getMonth().equals(11)) {
            return "Nov.";
        } else if (saveActivity.activityRowList.get(i).getMonth().equals(12)) {
            return "Dec.";
        }
    }
}
