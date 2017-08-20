package edu.chl.leep.model;

import java.io.Serializable;

/**
 * Created by Evelina on 2017-05-05.
 *
 * A class where the ActivityRowObject are being created from.
 */

public class ActivityObject implements Serializable { //TODO change name

    private UserModel user; //TODO change to user object from usermodel
    private String year;
    private String month;
    private String day;
    private String startTime;
    private String totalTime;
    private String categoryName;

    public ActivityObject(UserModel user, String year, String month, String day,
                          String startTime, String totalTime, String categoryName) { //TODO skicka in userobjekt
        this.user = user;
        this.year = year;
        this.month = month;
        this.day= day;
        this.startTime = startTime;
        this.totalTime = totalTime;
        this.categoryName = categoryName;
    }
    public UserModel getUser() {return user;}
    public String getYear () {return year;}
    public String getMonth () {return month;}
    public String getDay () {return day;}
    public String getStartTime () {return startTime;}
    public String getTotalTime () {return totalTime;}
    public String getCategoryName () {return categoryName;}
}
