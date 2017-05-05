package com.example.linneabark.test;

import java.text.Format;

/**
 * Created by Evelina on 2017-05-05.
 */

public class ActivityRow {
    private Format year;
    private Format month;
    private Format day;
    private long startTime;
    private long totalTime;
    private Category category;

    public ActivityRow (Format year, Format month, Format day, long startTime, long totalTime, Category category) {
        this.year = year;
        this.month = month;
        this.day= day;
        this.startTime = startTime;
        this.totalTime = totalTime;
        this.category = category;
    }

    public Format getYear () {return year;}
    public Format getMonth () {return month;}
    public Format getDay () {return day;}
    public long getStartTime () {return startTime;}
    public long getTotalTime () {return totalTime;}
    public Category getCategory () {return category;}
}
