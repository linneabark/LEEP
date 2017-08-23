package edu.chl.leep.service;

import java.util.ArrayList;
import java.util.List;

import edu.chl.leep.ctrl.StatisticsController;
import edu.chl.leep.model.ActivityObject;

/**
 * Created by linneabark on 2017-08-22.
 */

public class StatisticsDisplayService {

    private StatisticService sS;


    private StatisticsController sC = new StatisticsController();

    //handlar bara om vyn från listor med rätt information
    public void activityToString (List<String> allActivitys, List<ActivityObject> activityRowList, int indexFromForLoop){
        long stopTime = sC.getAllActivityRowsForSpecificMonth().get(indexFromForLoop).getStartTime()
                + sC.getAllActivityRowsForSpecificMonth().get(indexFromForLoop).getTotalTime();

        String s = sC.getAllActivityRowsForSpecificMonth().get(indexFromForLoop).getCategoryName()
                + "          " +
                (sC.getAllActivityRowsForSpecificMonth().get(indexFromForLoop).getStartTime()) + " - " + stopTime;

        allActivitys.add(s);

        activityRowList.add(sC.getAllActivityRowsForSpecificMonth().get(indexFromForLoop));
    }

    //kanske för klassen som hanterar view
    public List <String> reformListToDisplay (StatisticService sS) {

        sS.giveValuesToDefaultStatisticList(sC);
        List<String>listToDisplay = new ArrayList<>();

        for(int i = 0; i < sC.getDefaultStatisticsList().size(); i++) {
            /*long stopTime = Long.valueOf(takeAwayFirstZeros(defaultStatisticList.get(i).getStartTime()))
                    + Long.valueOf(takeAwayFirstZeros(defaultStatisticList.get(i).getTotalTime()));
            String s = defaultStatisticList.get(i).getCategoryName() + "    " + defaultStatisticList.get(i).getStartTime() + " - " + stopTime;
            listToDisplay.add(s);*/
            long stopTime = sC.getDefaultStatisticsList().get(i).getStartTime() + sC.getDefaultStatisticsList().get(i).getTotalTime();
            String s = sC.getDefaultStatisticsList().get(i).getCategoryName() + "    " + sC.getDefaultStatisticsList().get(i).getStartTime() + " - " + stopTime;
            listToDisplay.add(s);
        }
        return listToDisplay;
    }
}
