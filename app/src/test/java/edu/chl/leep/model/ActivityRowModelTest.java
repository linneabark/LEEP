package edu.chl.leep.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Evelinas on 2017-08-12.
 */

public class ActivityRowModelTest {

    @Test
    public void activityRow () throws Exception {
        ActivityRowModel aRM = new ActivityRowModel("Sven", "2017", "05", "25", "12334565", "2000", "Studier");

        assertTrue(aRM.getUserName().equals("Sven"));
        assertTrue(aRM.getYear().equals("2017"));
        assertTrue(aRM.getMonth().equals("05"));
        assertTrue(aRM.getDay().equals("25"));
        assertTrue(aRM.getStartTime().equals("12334565"));
        assertTrue(aRM.getTotalTime().equals("2000"));
        assertTrue(aRM.getCategoryName().equals("Studier"));
    }
}
