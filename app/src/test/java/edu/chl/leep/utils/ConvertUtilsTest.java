package edu.chl.leep.utils;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Eli on 2017-05-25.
 Is a Util class which converts Longs to String in the format vi want, and the other way around*/
public class ConvertUtilsTest {
    @Test
    public void calculateTimeToString() throws Exception {
        ConvertUtils sd = new ConvertUtils();
        long time1 = 3600000;
        assertTrue(sd.calculateTimeToString(time1).equals("01:00:00"));
        long time2 = 0;
        assertTrue(sd.calculateTimeToString(time2).equals("00:00:00"));
        long time3 = 12334565;
        assertTrue(sd.calculateTimeToString(time3).equals("03:25:34"));
        long time4 = 86400000; //24h
        assertTrue(sd.calculateTimeToString(time4).equals("24:00:00"));
        long time5 = 356400000 + 3540000 + 59000; //exactly 99:59:99
        assertTrue(sd.calculateTimeToString(time5).equals("99:59:59"));
        long time6 = 396400000; //more than 99:59:99
        assertTrue(sd.calculateTimeToString(time6).equals("99:59:59"));
    }

    @Test
    public void calculateDateToString() throws Exception {
        ConvertUtils sd = new ConvertUtils();
        Date date = new Date();
        assertTrue(sd.calculateDateToString(date).equals("2017-05-26"));

    }

}