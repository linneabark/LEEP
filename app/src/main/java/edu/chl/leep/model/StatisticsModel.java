package edu.chl.leep.model;

import com.example.linneabark.test.StatisticsActivityAdapter;

import java.util.ArrayList;
import java.util.List;

import edu.chl.leep.service.SaveActivity;
import edu.chl.leep.utils.FindWhichMonth;
import edu.chl.leep.utils.ConvertUtils;

/**
 * Created by Evelinas on 2017-05-26.
 */

public class StatisticsModel {

    private long oldTimeOfActivity = 0;

    private String whichBtn = "btnDay";
    private String dateBtn;
    private String monthBtn;

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
        System.out.println("reformListToDisplay SM");
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


    private List<ActivityRowModel> giveValuesToDefaultStatisticList () {
        System.out.println("giveValuesToDefaultStatisticList SM");
        int year = 0;
        int month = 0;
        int day = 0;

        System.out.println("userActivityList i giveValuesToDefaultStatisticsList : listans size --> " + userActivityList.size());

        for (int i = 0; i < userActivityList.size(); i++) {
            int yearFromList = intYearFromList(userActivityList,i);
            if (yearFromList > year) {
                year = yearFromList;
            }
        }

        //Find the greatest month in the greatest year
        for (int i = 0; i < userActivityList.size(); i++) {
            if (year == intYearFromList(userActivityList, i)){

                int monthFromList = intMonthFromList(userActivityList, i);
                if (monthFromList > month) {
                    month = monthFromList;
                }
            }
        }

        //find the greatest day in the greatest month and year
        for (int i = 0; i < userActivityList.size(); i++) {
            if (year == intYearFromList(userActivityList, i) && month == intMonthFromList(userActivityList, i)){

                int dayFromList = intDayFromList(userActivityList, i);
                if (dayFromList > day) {
                    day = dayFromList;
                }
            }
        }

        //Insert all the activitys from the greatest date
        for(int i = 0; i < userActivityList.size(); i++) {
            if(year == intYearFromList(userActivityList, i) &&
                    month == intMonthFromList(userActivityList, i) &&
                    day == intDayFromList(userActivityList, i)) {
                defaultStatisticList.add(userActivityList.get(i));
            }
        }

        System.out.println("default StatisticList --> size  = "+defaultStatisticList.size());
        return defaultStatisticList;
    }

    public void totalForActivity (List<ActivityRowModel> oneList) {
        long totalTimeOfEveryting = 0;

        //For loopen gör så att man kan gå igenom alla objekt från en månad
        for (int i = 0; i < oneList.size(); i++){
            //Hämtar kategorinamnet från alla objekt i listan
            String categoryName = oneList.get(i).getCategoryName();

            System.out.println("categpryname totalforactivity --> " + categoryName);

            //Hämtar indexet som kategorin ligger på.

            long totalTimeOfActivity = Long.valueOf(takeAwayFirstZeros(oneList.get(i).getTotalTime()));

            //Lägger till kategorinmanet i listan, om det ej finns i listan för att kunna jämföra med totaltiden av en kategori.
            if (!(totalOfCategoryList.contains(categoryName))) {

                totalOfCategoryList.add(categoryName);
                totalTimeList.add(totalOfCategoryList.indexOf(categoryName),totalTimeOfActivity);

            }
            else {
                int indexOfCategory = totalOfCategoryList.indexOf(categoryName);
                incActivityTotalTime(indexOfCategory, totalTimeOfActivity, totalTimeList.get(indexOfCategory));
            }
            System.out.println("index of v´categopry --> " + totalOfCategoryList.indexOf(categoryName));
//Hämtar den totala tiden just detta objekt la ner på just denna kategori
            System.out.println(" vad blir totalTimeList.get(indexOfCategory) --> " + totalTimeList.get(totalOfCategoryList.indexOf(categoryName)));

            totalTimeOfEveryting = totalTimeOfEveryting + oldTimeOfActivity;
            //Varje kategori har utförts en visstid(totalTime). Denna tid måste läggas till i listan som sparar den totala tiden.
            //Hämtar den totala tiden som redan ligger i listan som hanterar total tiden
            System.out.println("totalTimeList size in inc " + totalTimeList);

        }
    }

    private void incActivityTotalTime (int indexOfCategory, long totalTimeOfActivity, long oldTime) {
        //Läggger ihop tiden som redan låg i listan med den "nya" för objektet
        totalTimeOfActivity = totalTimeOfActivity + oldTime;
        System.out.println("totaltimeOfActivity " + totalTimeOfActivity);
        //Lägger till den ökade totaltiden i listan som innehåller total tider.
        totalTimeList.remove(indexOfCategory);
        totalTimeList.add(indexOfCategory, totalTimeOfActivity);

        oldTimeOfActivity = totalTimeOfActivity;
    }


    public List<String> getAllDays () {
        int count = 0;
        List <String> allDays = new ArrayList<>();
        System.out.println("Klass statisticsMomthAdapter, metod getAllDays.");
        int intMonth= findWhichMonth.numberOfMonth(monthBtn);

        System.out.println("Klass statistics, metod getAllDays. Värde på månad som trycks på " + intMonth);
        System.out.println("hur stor är userActivitylistan.. " + userActivityList.size());

        System.out.println();
        for(int i= 0; i < userActivityList.size(); i++ ){

            int intMonthFromList = Integer.valueOf(takeAwayFirstZeros(userActivityList.get(i).getMonth()));
            //int intDayFromList = Integer.valueOf(StatisticsController.takeAwayFirstZeros(StatisticsController.userActivityList.get(i).getDay()));
            if (whichBtn.equals("btnDay")) {
                if (intMonthFromList == intMonth) {
                    if(!(allDays.contains(userActivityList.get(i).getDay()))) {
                        //lägger till alla datum som loggats under en månad.
                        System.out.println("kommer jag in där vi lägger till i allDays?");
                        allDays.add(userActivityList.get(i).getDay());
                    }
                    //Bugg. Varje gång man byter månad kommer listan läggast till igen och visas som en dubbellista dör activitertrna visas.
                    allActivityRowsForSpecificMonth.add(userActivityList.get(i));
                    System.out.println("det som läggs till i allactivityrowsforspecificmonth: " + userActivityList.get(i));
                }
            } else if (whichBtn.equals("btnMonth")) {
                //Vill ej ha dagar i den listan just nu. I framtiden ändra till oklickbara knapar.
                if (intMonthFromList == intMonth) {
                    count++;
                    allActivityRowsForSpecificMonth.add(userActivityList.get(i));
                }
            }

        }

        if ((allDays.size() == 0) && (count == 0)){
            allDays.add("No logged days");
        }
        System.out.println("Får allDAys ngt " + allDays.size());
        System.out.println("Får allActivityRowsForSpecificMonth ngt " + allActivityRowsForSpecificMonth.size());

        return allDays;
    }

    public  List<String> getAllActivitys (StatisticsActivityAdapter statisticsActivityAdapter) {
        List <String> allActivitys = new ArrayList<>();
        List <ActivityRowModel> activityRowList = new ArrayList<>();

        System.out.println("Klass statisticsDateAdapter, metod getAllActivitys.");
        int intDate = Integer.valueOf(takeAwayFirstZeros(dateBtn));

        System.out.println("Klass statistics, metod getAllActivitys. Värde på datum som trycks på " + intDate);
        System.out.println("hur stor är listan.. " + userActivityList.size());

        System.out.println("hur stor är allactivityrow... --> " + allActivityRowsForSpecificMonth.size());

        if (whichBtn.equals("btnDay")) {
            for(int i = 0; i < allActivityRowsForSpecificMonth.size(); i++ ) {
                int intDayFromList = Integer.valueOf(takeAwayFirstZeros(allActivityRowsForSpecificMonth.get(i).getDay()));

                if (whichBtn.equals("btnDay")) {
                    if (intDayFromList == intDate) {
                        System.out.println("kommer jag in där vi lägger till i activiterna från en dag i allActivitys?");
                        activityToString(allActivitys, activityRowList, i);
                    }
                }
            }
        } else if (whichBtn.equals("btnMonth")) {
            for(int i= 0; i < allActivityRowsForSpecificMonth.size(); i++ ){
                System.out.println("kommer jag in där vi lägger till i activiterna från en månad i allActivitys?");
                activityToString(allActivitys, activityRowList, i);
            }

            System.out.println("kommer jag previs innan swap list  för månad i statisticsDAteMonth?");
            statisticsActivityAdapter.swapList(allActivitys);
        } else  {
            allActivitys.add("Something went wrong with how the activity should be shown");
        }

        totalForActivity(activityRowList);

        System.out.println("Får allActivitys ngt " + allActivitys.size());
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
