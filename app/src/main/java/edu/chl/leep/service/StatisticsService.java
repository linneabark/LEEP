package edu.chl.leep.service;

import java.util.ArrayList;
import java.util.List;

import edu.chl.leep.adapter.StatisticsActivityAdapter;
import edu.chl.leep.ctrl.StatisticsController;
import edu.chl.leep.model.ActivityObject;
import edu.chl.leep.utils.FindWhichMonth;
import edu.chl.leep.utils.StatisticsUtils;

/**
 * Created by Evelinas on 2017-08-20.
 */

public class StatisticsService {
    private FindWhichMonth findWhichMonth = new FindWhichMonth();

    public int intYearFromList (List<ActivityObject> list, int positionInList) {
        return list.get(positionInList).getYear();
    }
    public int intMonthFromList (List<ActivityObject> list, int positionInList) {
        return list.get(positionInList).getMonth();
    }
    public int intDayFromList (List<ActivityObject> list, int positionInList) {
        return list.get(positionInList).getDay();
    }

    public int greatestYear(int year, List<ActivityObject> list){
        for (int i = 0; i < list.size(); i++) {
            int yearFromList = intYearFromList(list,i);
            if (yearFromList > year) {
                year = yearFromList;
            }
        }
        return year;
    }
    public int greatestMonth(int year, int month, List<ActivityObject> list){
        for (int i = 0; i < list.size(); i++) {
            if (year == intYearFromList(list, i)){

                int monthFromList = intMonthFromList(list, i);
                if (monthFromList > month) {
                    month = monthFromList;
                }
            }
        }
        return month;
    }
    public int greatestDay(int year, int month, int day, List<ActivityObject> list) {
        for (int i = 0; i < list.size(); i++) {
            if (year == intYearFromList(list, i) && month == intMonthFromList(list, i)){

                int dayFromList = intDayFromList(list, i);
                if (dayFromList > day) {
                    day = dayFromList;
                }
            }
        }
        return day;
    }

    public List<Integer> getAllDays (StatisticsController sC) {
        int count = 0;
        int intMonth;
        List <Integer> allDays = new ArrayList<>();

        if(sC.getMonthBtn() == null){
            intMonth = sC.getMonth();
        } else {
            intMonth= findWhichMonth.numberOfMonth(sC.getMonthBtn());
        }

        for(int i= 0; i < sC.getUserActivityList().size(); i++ ){

            int intMonthFromList = sC.getUserActivityList().get(i).getMonth();
            if (sC.getWhichBtn().equals("btnDay")) {
                if (intMonthFromList == intMonth) {
                    if(!(allDays.contains(sC.getUserActivityList().get(i).getDay()))) {
                        allDays.add(sC.getUserActivityList().get(i).getDay());
                    }
                    //Bugg. Varje gång man byter månad kommer listan läggast till igen och visas som en dubbellista dör activitertrna visas.
                    sC.getAllActivityRowsForSpecificMonth().add(sC.getUserActivityList().get(i));
                }
            } else if (sC.getWhichBtn().equals("btnMonth")) {
                if (intMonthFromList == intMonth) {
                    count++;
                    sC.getAllActivityRowsForSpecificMonth().add(sC.getUserActivityList().get(i));
                }
            }

        }
        return allDays;
    }

    public List<String> getActivitysToDisplay (StatisticsDisplayService sDS, StatisticsController sC) {
        List<String> displayList = new ArrayList<>();

        List<ActivityObject> userList = sC.getUserActivityList();

        int monthInInt = -1;
        int dateInInt = -1;

        if (userList == null) {
            return displayList;
        } else {
            if(null == sC.getDateBtn()) {
                //sC.getMonthBtn will for example have the text "Aug."
                monthInInt = findWhichMonth.numberOfMonth(sC.getMonthBtn());
                return toGetListToDisplay(sC,userList,sDS,monthInInt, dateInInt);
            } else if(null == sC.getMonthBtn()){
                monthInInt = sC.getMonth();
                return toGetListToDisplay(sC,userList,sDS,monthInInt, dateInInt);
            } else {
                monthInInt = findWhichMonth.numberOfMonth(sC.getMonthBtn());
                dateInInt = Integer.valueOf(sC.getDateBtn());

                return toGetListToDisplay(sC,userList,sDS,monthInInt, dateInInt);
            }
        }
    }

    private List<String> toGetListToDisplay(StatisticsController sC, List<ActivityObject> userList, StatisticsDisplayService sDS, int monthInInt, int dateInInt){
        int greatestDate = 0;

        List<ActivityObject> rightMonthAllActivitys = new ArrayList<>();
        List<String> displayList = new ArrayList<>();

        if (sC.getWhichBtn().equals("btnDay")) {

            if (null == sC.getDateBtn()){
                //visa senaste daturmet i månaden per automatik.
                for(int i = 0; i < userList.size(); i++) {
                    if (monthInInt == userList.get(i).getMonth()) {
                        rightMonthAllActivitys.add(userList.get(i));
                    }
                }
                if (rightMonthAllActivitys == null) {
                    return displayList;
                } else {
                    greatestDate = biggestNumber(rightMonthAllActivitys, greatestDate);
                }
                for (int i = 0; i < rightMonthAllActivitys.size(); i++){
                    if (greatestDate == rightMonthAllActivitys.get(i).getDay()) {
                        displayList.add(sDS.displayString(rightMonthAllActivitys,i));
                    }
                }
                return displayList;

            } else {
                return dateAndMonthList(sC,userList,sDS,monthInInt, dateInInt);
            }
        } else if (sC.getWhichBtn().equals("btnMonth")) {
            for(int i = 0; i < userList.size(); i++) {
                if (monthInInt == userList.get(i).getMonth()) { //funkar ej med olika år
                    rightMonthAllActivitys.add(userList.get(i)); //innehåller alla object för månaden
                    displayList.add(sDS.displayString(rightMonthAllActivitys,i));
                }
            }
        } else {
            displayList.add("Something went wrong with how the activity should be shown");
        }
        return displayList;
    }

    private int biggestNumber (List<ActivityObject> activityList,  int greatestDate) {
        for(int i = 0; i < activityList.size(); i++){
            if(greatestDate < activityList.get(i).getDay()){
                greatestDate = activityList.get(i).getDay();
            }
        }
        return greatestDate;
    }

    private List<String> dateAndMonthList (StatisticsController sC, List<ActivityObject> userList, StatisticsDisplayService sDS, int monthInInt, int dateInInt) {
        List<String>displayList = new ArrayList<>();
        for(int i = 0; i < userList.size(); i++) {
            if (monthInInt == userList.get(i).getMonth() && dateInInt == userList.get(i).getDay()) { //funkar ej med olika år
                displayList.add(sDS.displayString(userList,i));
            }
        }
        return displayList;
    }

}
