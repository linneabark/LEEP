package edu.chl.leep.utils;

import java.text.Format;

/**
 * Created by Evelina on 2017-05-06.
 */

public class FindWhichMonth {
    /*
    -statisk klass där jag har en array där jag lägger till alla månader. metod. getName. Den tar ditt nummer
    minus ett och då får man månadens namn.
    -vill man åt andra hållet så tar man indexOf och från namnet och då
    -får man indexet ur arrayen och tar man plus ett så får man månadens nummer
    */
    public static String [] months = {"Jan.", "Feb.", "Mar.", "Apr.", "May", "Jun.",
                                        "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."};

    public String nameOfMonth (String day) {
        int i = Integer.parseInt(day);

        String nameMonth = months[i-1];

        return nameMonth;
    }

    //int numberMonth = -1 och numberMonth = 1 + i ; är nog onödigt tydliga.
    public static int numberOfMonth (String day) {
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
