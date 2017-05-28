package edu.chl.leep.model;

import java.io.Serializable;

/**
 * Created by Evelina on 2017-05-05.
 */

public class ActivityRowModel implements Serializable {
    private String userName;
    private String year;
    private String month;
    private String day;
    private String startTime;
    private String totalTime;
    private String categoryName;

    public ActivityRowModel(String userName, String year, String month, String day,
                            String startTime, String totalTime, String categoryName) {
        this.userName = userName;
        this.year = year;
        this.month = month;
        this.day= day;
        this.startTime = startTime;
        this.totalTime = totalTime;
        this.categoryName = categoryName;
    }
    public String getUserName () {return userName;}
    public String getYear () {return year;}
    public String getMonth () {return month;}
    public String getDay () {return day;}
    public String getStartTime () {return startTime;}
    public String getTotalTime () {return totalTime;}
    public String getCategoryName () {return categoryName;}
}
