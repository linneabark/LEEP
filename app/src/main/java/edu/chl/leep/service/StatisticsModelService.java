package edu.chl.leep.service;

import java.util.List;

import edu.chl.leep.model.ActivityObject;

/**
 * Created by Evelinas on 2017-08-20.
 */

public class StatisticsModelService {
    //Metoden anv'nds för att ta bort nollan på knappen som läses av. För att veta vilken
    public String takeAwayFirstZeros (String string) { //TODO, spara månader i int , representationen kanändras med nolla innan.
        string = string.replaceFirst("^0+(?!$)", "");
        return string;
    }

    public int greatestYear(List<ActivityObject> list, int year){
        for (int i = 0; i < list.size(); i++) {
            int yearFromList = list.get(i).getYear();
            if (yearFromList > year) {
                year = yearFromList;
            }
        }
        return year;
    }
    public int greatestMonth(List<ActivityObject> list, int year, int month){
        for (int i = 0; i < list.size(); i++) {
            if (year == list.get(i).getYear()){

                int monthFromList = list.get(i).getMonth();
                if (monthFromList > month) {
                    month = monthFromList;
                }
            }
        }
        return month;
    }
    public int greatestDay(List<ActivityObject> list, int year, int month, int day) {
        for (int i = 0; i < list.size(); i++) {
            if (year == list.get(i).getYear() && month == list.get(i).getMonth()){

                int dayFromList = list.get(i).getDay();
                if (dayFromList > day) {
                    day = dayFromList;
                }
            }
        }
        return day;
    }
}
