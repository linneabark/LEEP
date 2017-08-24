package edu.chl.leep.service;

import java.util.ArrayList;
import java.util.List;

import edu.chl.leep.ctrl.StatisticsController;
import edu.chl.leep.model.ActivityObject;
import edu.chl.leep.utils.ConvertUtils;
import edu.chl.leep.utils.FindWhichMonth;

/**
 * Created by linneabark on 2017-08-22.
 */

public class StatisticsDisplayService {

    private ConvertUtils convertUtils = new ConvertUtils();

    private List<ActivityObject> giveValuesToDefaultStatisticList (StatisticsController sC, StatisticsService sS) {
        //Find the greatest year in the list
        sC.setYear(sS.greatestYear(sC.getYear(), sC.getUserActivityList()));

        //Find the greatest month in the greatest year
        sC.setMonth(sS.greatestMonth(sC.getYear(), sC.getMonth(), sC.getUserActivityList()));

        //find the greatest day in the greatest month and year
        sC.setDay(sS.greatestDay(sC.getYear(), sC.getMonth(), sC.getDay(), sC.getUserActivityList()));

        //Insert all the activitys from the greatest date
        for(int i = 0; i < sC.getUserActivityList().size(); i++) {
            if(sC.getYear() == sS.intYearFromList(sC.getUserActivityList(), i) &&
                    sC.getMonth() == sS.intMonthFromList(sC.getUserActivityList(), i) &&
                    sC.getDay() == sS.intDayFromList(sC.getUserActivityList(), i)) {
                sC.getDefaultStatisticList().add(sC.getUserActivityList().get(i));
            }
        }
        return sC.getDefaultStatisticList();
    }

    public List <String> reformListToDisplay (StatisticsController sC, StatisticsService sS) {
        giveValuesToDefaultStatisticList(sC, sS);
        List<String>listToDisplay = new ArrayList<>();

        for(int i = 0; i < sC.getDefaultStatisticList().size(); i++) {
            String whatToDisplay = displayString(sC.getDefaultStatisticList(), i);
            listToDisplay.add(whatToDisplay);
        }
        return listToDisplay;
    }

    public String displayString(List<ActivityObject> list, int indexFromLoop) {
        long stopTime = list.get(indexFromLoop).getStartTime()
                + list.get(indexFromLoop).getTotalTime();

        String s = list.get(indexFromLoop).getCategoryName()
                + "    "
                + convertUtils.timeMillisToString(list.get(indexFromLoop).getStartTime())
                + " - "
                + convertUtils.timeMillisToString(stopTime);

        return s;
    }

    public String [] monthsInOrder (StatisticsController sC, FindWhichMonth fWM) {
        int [] numbers = {1, 2, 3, 4, 5,
                6, 7, 8, 9, 10, 11, 12};
        int month = sC.getMonth();

        String [] monthsInOrder = new String [12];
        int index = 0;

        for (int i = 0; i < numbers.length; i++){
            if(month == numbers[i]){
                int n = i;
                for(int k = 0 ; k < fWM.months.length; k++){
                    monthsInOrder[index] = fWM.months[n];
                    index ++;
                    n++;
                    if (fWM.months[n].equals("Dec.")) {
                        n = 0;
                    }
                }
            }
        }
        return monthsInOrder;
    }

}
