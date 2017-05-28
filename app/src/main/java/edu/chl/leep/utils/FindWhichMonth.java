package edu.chl.leep.utils;

/**
 * Created by Evelina on 2017-05-06.
 *
 *  A class which contains the months of a year, and a method that gives the number of a month
 */

public class FindWhichMonth {

    public String [] months = {"Jan.", "Feb.", "Mar.", "Apr.", "May", "Jun.",
                                        "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."};

    public int numberOfMonth (String day) {
        int numberMonth = -1;
        for (int i = 0; i < months.length; i++){
            if (day.equals(months[i])) {
                numberMonth = i + 1;
                return numberMonth;
            }
        }
        return -1;
    }
}
