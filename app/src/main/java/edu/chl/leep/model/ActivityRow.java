package edu.chl.leep.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Evelina on 2017-05-05.
 */

public class ActivityRow implements Serializable {
    // TODO Single activity
    private String year;
    private String month;
    private String day;
    private long startTime;
    private long totalTime;
    private String categoryName;


    public ActivityRow (String year, String month, String day, long startTime, long totalTime, String categoryName) {
        this.year = year;
        this.month = month;
        this.day= day;
        this.startTime = startTime;
        this.totalTime = totalTime;
        this.categoryName = categoryName;
    }

    public String getYear () {return year;}
    public String getMonth () {return month;}
    public String getDay () {return day;}
    public long getStartTime () {return startTime;}
    public long getTotalTime () {return totalTime;}
    public String getCategoryName () {return categoryName;}
}
