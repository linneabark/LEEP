package com.example.linneabark.test;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Evelina on 2017-05-05.
 */

public class ActivityRow implements Serializable {
    private String year;
    private String month;
    private String day;
    private long startTime;
    private long totalTime;
    private Category category;
    private CategoryHashMap categoryHashMap;
    private String categoryName;
    private int categoryColor;

    public ActivityRow (String year, String month, String day, long startTime, long totalTime, Category category) {
        this.year = year;
        this.month = month;
        this.day= day;
        this.startTime = startTime;
        this.totalTime = totalTime;
        this.category = category;
        //this.categoryHashMap = category;
        //this.categoryName = categoryName;
        //this.categoryColor = categoryColor;

    }

    public String getYear () {return year;}
    public String getMonth () {return month;}
    public String getDay () {return day;}
    public long getStartTime () {return startTime;}
    public long getTotalTime () {return totalTime;}
    public Category getCategory () {return category;}
    /*
    private Date year;
    private Date month;
    private Date day;
    private long startTime;
    private long totalTime;
    private Category category;

    public ActivityRow (Date year, Date month, Date day, long startTime, long totalTime, Category category) {
        this.year = year;
        this.month = month;
        this.day= day;
        this.startTime = startTime;
        this.totalTime = totalTime;
        this.category = category;
    }

    public Date getYear () {return year;}
    public Date getMonth () {return month;}
    public Date getDay () {return day;}
    public long getStartTime () {return startTime;}
    public long getTotalTime () {return totalTime;}
    public Category getCategory () {return category;}
    */
}
