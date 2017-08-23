package edu.chl.leep.service;

import java.util.ArrayList;
import java.util.List;

import edu.chl.leep.adapter.StatisticsActivityAdapter;
import edu.chl.leep.ctrl.StatisticsController;
import edu.chl.leep.model.ActivityObject;
import edu.chl.leep.model.StatisticsModel;
import edu.chl.leep.utils.FindWhichMonth;
import edu.chl.leep.utils.StatisticsUtils;

/**
 * Created by Evelinas on 2017-08-20.
 */

public class StatisticService {
    private String whichBtn = "btnDay";
    private String dateBtn;
    private String monthBtn;

    private int year = 0;
    private int month = 0;
    private int day = 0;

    //har månad i int.

    private StatisticsController sC = new StatisticsController();
    private StatisticsDisplayService sDS;

    private StatisticsUtils sU= new StatisticsUtils();
    private StatisticsModel sM = new StatisticsModel();
    private FindWhichMonth fWM = new FindWhichMonth();


    public StatisticService() {

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

    public  List<String> getAllActivitys (StatisticsActivityAdapter statisticsActivityAdapter) {
        List <String> allActivitys = new ArrayList<>();
        List <ActivityObject> activityRowList = new ArrayList<>();

        sDS = new StatisticsDisplayService();

        int intDate = Integer.valueOf(sU.takeAwayFirstZeros(dateBtn));

        if (whichBtn.equals("btnDay")) {
            for(int i = 0; i < sC.getAllActivityRowsForSpecificMonth().size(); i++ ) {
                int intDayFromList = sC.getAllActivityRowsForSpecificMonth().get(i).getDay();

                if (whichBtn.equals("btnDay")) {
                    if (intDayFromList == intDate) {
                        sDS.activityToString(allActivitys, activityRowList, i);
                    }
                }
            }
        } else if (whichBtn.equals("btnMonth")) {
            for(int i= 0; i < sC.getAllActivityRowsForSpecificMonth().size(); i++ ){
                sDS.activityToString(allActivitys, activityRowList, i);
            }
            statisticsActivityAdapter.swapList(allActivitys);
        } else  {
            allActivitys.add("Something went wrong with how the activity should be shown");
        }

        sC.totalForActivity(activityRowList);

        return allActivitys;
    }

    public List<Integer> getAllDays () {
        int count = 0;
        int intMonth;
        List <Integer> allDays = new ArrayList<>();

        if(monthBtn == null){
            intMonth = month;
        } else {
            intMonth= fWM.numberOfMonth(monthBtn);
        }

        for(int i= 0; i < sC.getUserActivityList().size(); i++ ){

            int intMonthFromList = sC.getUserActivityList().get(i).getMonth();
            if (whichBtn.equals("btnDay")) {
                if (intMonthFromList == intMonth) {
                    if(!(allDays.contains(sC.getUserActivityList().get(i).getDay()))) {
                        allDays.add(sC.getUserActivityList().get(i).getDay());
                    }
                    //Bugg. Varje gång man byter månad kommer listan läggast till igen och visas som en dubbellista dör activitertrna visas.
                    sC.getAllActivityRowsForSpecificMonth().add(sC.getUserActivityList().get(i));
                }
            } else if (whichBtn.equals("btnMonth")) {
                if (intMonthFromList == intMonth) {
                    count++;
                    sC.getAllActivityRowsForSpecificMonth().add(sC.getUserActivityList().get(i));
                }
            }

        }
        return allDays;
    }
    public List<ActivityObject> giveValuesToDefaultStatisticList (StatisticsController statisticsController) {
        //Find the greatest year in the list
        year = sU.greatestYear(statisticsController.getUserActivityList(), year);

        //Find the greatest month in the greatest year
        month = sU.greatestMonth(statisticsController.getUserActivityList(), year, month);

        //find the greatest day in the greatest month and year
        day = sU.greatestDay(statisticsController.getUserActivityList(), year, month, day);

        //Insert all the activitys from the greatest date
        for(int i = 0; i < statisticsController.getUserActivityList().size(); i++) {
            if(year == statisticsController.getUserActivityList().get(i).getYear() &&
                    month == statisticsController.getUserActivityList().get(i).getMonth() &&
                    day == statisticsController.getUserActivityList().get(i).getDay()) {
                statisticsController.getDefaultStatisticsList().add(statisticsController.getUserActivityList().get(i));
            }
        }
        return sC.getDefaultStatisticsList();
    }
}
