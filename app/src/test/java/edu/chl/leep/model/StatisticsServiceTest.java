package edu.chl.leep.model;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Created by Evelinas on 2017-08-12.
 */

public class StatisticsServiceTest {

    @Test
    public void greatestYearTest() throws Exception {
        int [] year = {2017,2016,2018};
        int greatestYear = 0;
        for (int i = 0; i < year.length; i++) {
            if (year[i] > greatestYear) {
                greatestYear = year[i];
            }
        }
        assertTrue(greatestYear == 2018);
    }

    @Test
    public void greatestMonthTest() throws Exception {
        int greatestYear = 0;
        int greatestMonth = 0;
        int[][] yearAndMonth = {
                {2016, 9},
                {2017, 1},
                {2017, 6}
        };

        for (int i = 0; i < yearAndMonth.length; i++) {
            if (yearAndMonth[i][0] > greatestYear) {
                greatestYear = yearAndMonth[i][0];
            }
        }
        for (int i = 0; i < yearAndMonth.length; i++) {
            if(greatestYear == yearAndMonth[i][0]) {
                if(yearAndMonth[i][1] > greatestMonth) {
                    greatestMonth = yearAndMonth[i][1];
                }
            }
        }
        assertTrue(greatestYear == 2017);
        assertTrue(greatestMonth == 6);
    }

    @Test
    public void greatestDayTest() throws  Exception {
        int greatestYear = 0;
        int greatestMonth = 0;
        int greatestDay = 0;
        int[][][] yearAndMonth = {{
                {2016, 9, 30},
                {2017, 1, 25},
                {2017, 6, 6}
        }};

        for (int i = 0; i < yearAndMonth.length; i++) {
            if (yearAndMonth[0][i][0] > greatestYear) {
                greatestYear = yearAndMonth[0][i][0];
            }
        }
        for (int i = 0; i < yearAndMonth.length; i++) {
            if (greatestYear == yearAndMonth[0][i][0]) {
                if (yearAndMonth[0][i][1] > greatestMonth) {
                    greatestMonth = yearAndMonth[0][i][1];
                }
            }
        }
        for (int i = 0; i < yearAndMonth.length; i++) {
            if (greatestYear == yearAndMonth[0][i][0] && yearAndMonth[0][i][1] > greatestMonth) {

                if (yearAndMonth[0][i][2] > greatestDay) {
                    greatestDay = yearAndMonth[0][i][2];
                }
            }
        }

        assertTrue(String.valueOf(greatestYear), true);
        assertTrue(String.valueOf(greatestMonth), true);
        assertTrue(String.valueOf(greatestDay), true);
    }}