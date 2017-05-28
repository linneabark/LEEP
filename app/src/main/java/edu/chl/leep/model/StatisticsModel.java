package edu.chl.leep.model;

import com.example.linneabark.test.StatisticsActivityAdapter;

import java.util.ArrayList;
import java.util.List;

import edu.chl.leep.service.SaveActivity;
import edu.chl.leep.utils.FindWhichMonth;
import edu.chl.leep.utils.ConvertUtils;

/**
 * Created by Evelinas on 2017-05-26.
 *
 * A model class which contains methods that are being used in StatisticsController, and the three Statistics...Adapters
 */

public class StatisticsModel {

    private long oldTimeOfActivity = 0;

    private String whichBtn = "btnDay";
    private String dateBtn;
    private String monthBtn;

    private int year = 0;
    private int month = 0;
    private int day = 0;

    //har månad i int.

    private FindWhichMonth findWhichMonth;
    private List <ActivityRowModel> defaultStatisticList;
    private List<ActivityRowModel> userActivityList;
    private List <ActivityRowModel> allActivityRowsForSpecificMonth;
    private List<String> totalOfCategoryList;
    private List<Long> totalTimeList;

    public StatisticsModel(){
        findWhichMonth = new FindWhichMonth();
        defaultStatisticList = new ArrayList<>();
        userActivityList = SaveActivity.activityRowList;
        allActivityRowsForSpecificMonth = new ArrayList<>();
        totalOfCategoryList = new ArrayList<>();
        totalTimeList = new ArrayList<>();
    }
    private String takeAwayFirstZeros (String string) {
        string = string.replaceFirst("^0+(?!$)", "");
        return string;
    }

    private int intYearFromList (List<ActivityRowModel> list, int positionInList) {
        return Integer.valueOf(takeAwayFirstZeros(list.get(positionInList).getYear()));
    }
    private int intMonthFromList (List<ActivityRowModel> list, int positionInList) {
        return Integer.valueOf(takeAwayFirstZeros(list.get(positionInList).getMonth()));
    }
    private int intDayFromList (List<ActivityRowModel> list, int positionInList) {
        return Integer.valueOf(takeAwayFirstZeros(list.get(positionInList).getDay()));
    }

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


    public List <String> reformListToDisplay () {
        giveValuesToDefaultStatisticList();
        List<String>listToDisplay = new ArrayList<>();

        for(int i = 0; i < defaultStatisticList.size(); i++) {
            long stopTime = Long.valueOf(takeAwayFirstZeros(defaultStatisticList.get(i).getStartTime()))
                    + Long.valueOf(takeAwayFirstZeros(defaultStatisticList.get(i).getTotalTime()));
            String s = defaultStatisticList.get(i).getCategoryName() + "    " + defaultStatisticList.get(i).getStartTime() + " - " + stopTime;
            listToDisplay.add(s);
        }
        return listToDisplay;
    }

    private int greatestYear(int year){
        for (int i = 0; i < userActivityList.size(); i++) {
            int yearFromList = intYearFromList(userActivityList,i);
            if (yearFromList > year) {
                year = yearFromList;
            }
        }
        return year;
    }
    private int greatestMonth(int year, int month){
        for (int i = 0; i < userActivityList.size(); i++) {
            if (year == intYearFromList(userActivityList, i)){

                int monthFromList = intMonthFromList(userActivityList, i);
                if (monthFromList > month) {
                    month = monthFromList;
                }
            }
        }
        return month;
    }
    private int greatestDay(int year, int month, int day) {
        for (int i = 0; i < userActivityList.size(); i++) {
            if (year == intYearFromList(userActivityList, i) && month == intMonthFromList(userActivityList, i)){

                int dayFromList = intDayFromList(userActivityList, i);
                if (dayFromList > day) {
                    day = dayFromList;
                }
            }
        }
        return day;
    }

    public int getMonth(){
        return month;
    }

    private List<ActivityRowModel> giveValuesToDefaultStatisticList () {
        //Find the greatest year in the list
        year =   greatestYear(year);

        //Find the greatest month in the greatest year
        month = greatestMonth(year, month);

        //find the greatest day in the greatest month and year
        day = greatestDay(year, month, day);

        //Insert all the activitys from the greatest date
        for(int i = 0; i < userActivityList.size(); i++) {
            if(year == intYearFromList(userActivityList, i) &&
                    month == intMonthFromList(userActivityList, i) &&
                    day == intDayFromList(userActivityList, i)) {
                defaultStatisticList.add(userActivityList.get(i));
            }
        }
        return defaultStatisticList;
    }

    public void totalForActivity (List<ActivityRowModel> oneList) {
        long totalTimeOfEveryting = 0;

        for (int i = 0; i < oneList.size(); i++){
            String categoryName = oneList.get(i).getCategoryName();

            long totalTimeOfActivity = Long.valueOf(takeAwayFirstZeros(oneList.get(i).getTotalTime()));

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

    public List<String> getAllDays () {
        int count = 0;
        int intMonth;
        List <String> allDays = new ArrayList<>();

        if(monthBtn == null){
            intMonth = month;
        } else {
            intMonth= findWhichMonth.numberOfMonth(monthBtn);
        }

        for(int i= 0; i < userActivityList.size(); i++ ){

            int intMonthFromList = Integer.valueOf(takeAwayFirstZeros(userActivityList.get(i).getMonth()));
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
        List <ActivityRowModel> activityRowList = new ArrayList<>();

        int intDate = Integer.valueOf(takeAwayFirstZeros(dateBtn));

        if (whichBtn.equals("btnDay")) {
            for(int i = 0; i < allActivityRowsForSpecificMonth.size(); i++ ) {
                int intDayFromList = Integer.valueOf(takeAwayFirstZeros(allActivityRowsForSpecificMonth.get(i).getDay()));

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

    private void activityToString (List <String> allActivitys, List<ActivityRowModel> activityRowList, int indexFromForLoop){
        ConvertUtils sd = new ConvertUtils();
        long stopTime = Long.valueOf(takeAwayFirstZeros(allActivityRowsForSpecificMonth.get(indexFromForLoop).getStartTime()))
                + Long.valueOf(takeAwayFirstZeros(allActivityRowsForSpecificMonth.get(indexFromForLoop).getTotalTime()));

        String s = allActivityRowsForSpecificMonth.get(indexFromForLoop).getCategoryName()
                + "          " +
                sd.calculateStringToLong(allActivityRowsForSpecificMonth.get(indexFromForLoop).getStartTime()) + " - " + stopTime;

        allActivitys.add(s);

        activityRowList.add(allActivityRowsForSpecificMonth.get(indexFromForLoop));
    }


}
