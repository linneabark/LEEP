package edu.chl.leep.model;

import java.io.Serializable;

/**
 * Created by Evelina on 2017-05-05.
 *
 * A class where the ActivityRowObject are being created from.
 */

public class ActivityObject implements Serializable { //TODO change name

    private UserModel user; //TODO change to user object from usermodel
    private int year;
    private int month;
    private int day;
    private long startTime;
    private long totalTime;
    private String categoryName;

    public ActivityObject(UserModel user, int year, int month, int day,
                          long startTime, long totalTime, String categoryName) { //TODO skicka in userobjekt
        this.user = user;
        this.year = year;
        this.month = month;
        this.day= day;
        this.startTime = startTime;
        this.totalTime = totalTime;
        this.categoryName = categoryName;
    }
    public UserModel getUser() {return user;}
    public int getYear () {return year;}
    public int getMonth () {return month;}
    public int getDay () {return day;}
    public long getStartTime () {return startTime;}
    public long getTotalTime () {return totalTime;}
    public String getCategoryName () {return categoryName;}
}
