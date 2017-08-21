package edu.chl.leep.model;

import edu.chl.leep.adapter.StatisticsActivityAdapter;

import java.util.ArrayList;
import java.util.List;

import edu.chl.leep.service.SaveActivity;
import edu.chl.leep.service.StatisticsModelService;
import edu.chl.leep.utils.FindWhichMonth;
import edu.chl.leep.utils.ConvertUtils;

/**
 * Created by Evelinas on 2017-05-26.
 *
 * A model class which contains methods that are being used in StatisticsController, and the three Statistics...Adapters
 */

public class StatisticsModel { //TODO transform to service, skala av

    private long oldTimeOfActivity = 0;

    private String whichBtn = "btnDay";
    private String dateBtn;
    private String monthBtn;

    private int year = 0;
    private int month = 0;
    private int day = 0;

    //har månad i int.

    private FindWhichMonth findWhichMonth;
    private List <ActivityObject> defaultStatisticList;
    private List<ActivityObject> userActivityList;
    private List <ActivityObject> allActivityRowsForSpecificMonth;
    private List<String> totalOfCategoryList;
    private List<Long> totalTimeList;

    StatisticsModelService  sMS = new StatisticsModelService();


    public StatisticsModel(){
        findWhichMonth = new FindWhichMonth();
        defaultStatisticList = new ArrayList<>();
        userActivityList = SaveActivity.activityRowList;
        allActivityRowsForSpecificMonth = new ArrayList<>();
        totalOfCategoryList = new ArrayList<>();
        totalTimeList = new ArrayList<>();
    }
    /*//Metoden anv'nds för att ta bort nollan på knappen som läses av. För att veta vilken
    private String takeAwayFirstZeros (String string) { //TODO, spara månader i int , representationen kanändras med nolla innan.
        string = string.replaceFirst("^0+(?!$)", "");
        return string;
    }*/

    /*private int intYearFromList (List<ActivityObject> list, int positionInList) {
        return Integer.valueOf(takeAwayFirstZeros(list.get(positionInList).getYear()));
    }
    private int intMonthFromList (List<ActivityObject> list, int positionInList) {
        return Integer.valueOf(takeAwayFirstZeros(list.get(positionInList).getMonth()));
    }
    private int intDayFromList (List<ActivityObject> list, int positionInList) {
        return Integer.valueOf(takeAwayFirstZeros(list.get(positionInList).getDay()));
    }*/

    public void setDateBtn(String dateBtn) {
        this.dateBtn = dateBtn;
    }

    public void setMonthBtn(String monthBtn) {
        this.monthBtn = monthBtn;
    }

    public void setWhichBtn (String btn) {
        whichBtn = btn;
    }

    public List<String> getTotalOfCategoryList () {
        return totalOfCategoryList;
    }

    public List<Long> getTotalTimeList () {
        return totalTimeList;
    }


    //kanske för klassen som hanterar view
    public List <String> reformListToDisplay () {
        giveValuesToDefaultStatisticList();
        List<String>listToDisplay = new ArrayList<>();

        for(int i = 0; i < defaultStatisticList.size(); i++) {
            /*long stopTime = Long.valueOf(takeAwayFirstZeros(defaultStatisticList.get(i).getStartTime()))
                    + Long.valueOf(takeAwayFirstZeros(defaultStatisticList.get(i).getTotalTime()));
            String s = defaultStatisticList.get(i).getCategoryName() + "    " + defaultStatisticList.get(i).getStartTime() + " - " + stopTime;
            listToDisplay.add(s);*/
            long stopTime = defaultStatisticList.get(i).getStartTime() + defaultStatisticList.get(i).getTotalTime();
            String s = defaultStatisticList.get(i).getCategoryName() + "    " + defaultStatisticList.get(i).getStartTime() + " - " + stopTime;
            listToDisplay.add(s);
        }
        return listToDisplay;
    }
    //TODO serivice som stuvar om datan. service klass har ej instance variabler men bara beräkningar
    /*private int greatestYear(List<ActivityObject> list, int year){
        for (int i = 0; i < list.size(); i++) {
            int yearFromList = list.get(i).getYear();
            if (yearFromList > year) {
                year = yearFromList;
            }
        }
        return year;
    }
    private int greatestMonth(List<ActivityObject> list, int year, int month){
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
    private int greatestDay(List<ActivityObject> list, int year, int month, int day) {
        for (int i = 0; i < list.size(); i++) {
            if (year == list.get(i).getYear() && month == list.get(i).getMonth()){

                int dayFromList = list.get(i).getDay();
                if (dayFromList > day) {
                    day = dayFromList;
                }
            }
        }
        return day;
    }*/
    //TODO view delarna hanterar datan för att se bra ut på utskrift

    private List<ActivityObject> giveValuesToDefaultStatisticList () {
        //Find the greatest year in the list
        year = sMS.greatestYear(userActivityList, year);

        //Find the greatest month in the greatest year
        month = sMS.greatestMonth(userActivityList, year, month);

        //find the greatest day in the greatest month and year
        day = sMS.greatestDay(userActivityList, year, month, day);

        //Insert all the activitys from the greatest date
        for(int i = 0; i < userActivityList.size(); i++) {
            if(year == userActivityList.get(i).getYear() &&
                    month == userActivityList.get(i).getMonth() &&
                    day == userActivityList.get(i).getDay()) {
                defaultStatisticList.add(userActivityList.get(i));
            }
        }
        return defaultStatisticList;
    }

    //metod för att potionera piecharten
    public void totalForActivity (List<ActivityObject> oneList) {
        long totalTimeOfEveryting = 0;

        for (int i = 0; i < oneList.size(); i++){
            String categoryName = oneList.get(i).getCategoryName();

            long totalTimeOfActivity = oneList.get(i).getTotalTime();

            if (!(totalOfCategoryList.contains(categoryName))) {
                totalOfCategoryList.add(categoryName);
                totalTimeList.add(totalOfCategoryList.indexOf(categoryName),totalTimeOfActivity);
            }
            else {
                int indexOfCategory = totalOfCategoryList.indexOf(categoryName);
                incActivityTotalTime(indexOfCategory, totalTimeOfActivity, totalTimeList.get(indexOfCategory));
            }
            totalTimeOfEveryting = totalTimeOfEveryting + oldTimeOfActivity;
        }
    }

    private void incActivityTotalTime (int indexOfCategory, long totalTimeOfActivity, long oldTime) {
        totalTimeOfActivity = totalTimeOfActivity + oldTime;

        totalTimeList.remove(indexOfCategory);
        totalTimeList.add(indexOfCategory, totalTimeOfActivity);

        oldTimeOfActivity = totalTimeOfActivity;
    }
    //TODO, model och statistic skall ej jobba tsm. CONTROLLERN hanterar listorna och skickar dem vidare. Rådatan i modelen
    public List<Integer> getAllDays () {
        int count = 0;
        int intMonth;
        List <Integer> allDays = new ArrayList<>();

        if(monthBtn == null){
            intMonth = month;
        } else {
            intMonth= findWhichMonth.numberOfMonth(monthBtn);
        }

        for(int i= 0; i < userActivityList.size(); i++ ){

            int intMonthFromList = userActivityList.get(i).getMonth();
            if (whichBtn.equals("btnDay")) {
                if (intMonthFromList == intMonth) {
                    if(!(allDays.contains(userActivityList.get(i).getDay()))) {
                        allDays.add(userActivityList.get(i).getDay());
                    }
                    //Bugg. Varje gång man byter månad kommer listan läggast till igen och visas som en dubbellista dör activitertrna visas.
                    allActivityRowsForSpecificMonth.add(userActivityList.get(i));
                }
            } else if (whichBtn.equals("btnMonth")) {
                if (intMonthFromList == intMonth) {
                    count++;
                    allActivityRowsForSpecificMonth.add(userActivityList.get(i));
                }
            }

        }
        return allDays;
    }

    public  List<String> getAllActivitys (StatisticsActivityAdapter statisticsActivityAdapter) {
        List <String> allActivitys = new ArrayList<>();
        List <ActivityObject> activityRowList = new ArrayList<>();

        int intDate = Integer.valueOf(sMS.takeAwayFirstZeros(dateBtn));

        if (whichBtn.equals("btnDay")) {
            for(int i = 0; i < allActivityRowsForSpecificMonth.size(); i++ ) {
                int intDayFromList = allActivityRowsForSpecificMonth.get(i).getDay();

                if (whichBtn.equals("btnDay")) {
                    if (intDayFromList == intDate) {
                        activityToString(allActivitys, activityRowList, i);
                    }
                }
            }
        } else if (whichBtn.equals("btnMonth")) {
            for(int i= 0; i < allActivityRowsForSpecificMonth.size(); i++ ){
                activityToString(allActivitys, activityRowList, i);
            }
            statisticsActivityAdapter.swapList(allActivitys);
        } else  {
            allActivitys.add("Something went wrong with how the activity should be shown");
        }

        totalForActivity(activityRowList);

        return allActivitys;
    }

    //handlar bara om vyn från listor med rätt information
    private void activityToString (List <String> allActivitys, List<ActivityObject> activityRowList, int indexFromForLoop){
        long stopTime = allActivityRowsForSpecificMonth.get(indexFromForLoop).getStartTime()
                + allActivityRowsForSpecificMonth.get(indexFromForLoop).getTotalTime();

        String s = allActivityRowsForSpecificMonth.get(indexFromForLoop).getCategoryName()
                + "          " +
                (allActivityRowsForSpecificMonth.get(indexFromForLoop).getStartTime()) + " - " + stopTime;

        allActivitys.add(s);

        activityRowList.add(allActivityRowsForSpecificMonth.get(indexFromForLoop));
    }


}
