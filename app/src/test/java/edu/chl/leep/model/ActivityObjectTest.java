package edu.chl.leep.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Evelinas on 2017-08-12.
 */

public class ActivityObjectTest {

    @Test
    public void activityObjectTest() throws Exception {
        ActivityObject aRM = new ActivityObject(new UserModel("Sven", "sensson@hej.se", "svensson"), 2017, 05, 25, 12334565, 2000, "Studier");

        assertTrue(aRM.getUser().getLogin().equals("Sven"));
        assertTrue(aRM.getYear() == 2017);
        assertTrue(aRM.getMonth() == 05);
        assertTrue(aRM.getDay() == 25);
        assertTrue(aRM.getStartTime() == 12334565);
        assertTrue(aRM.getTotalTime() == 2000);
        assertTrue(aRM.getCategoryName().equals("Studier"));
    }
}
