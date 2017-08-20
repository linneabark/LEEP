package edu.chl.leep.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Evelinas on 2017-08-12.
 */

public class LeepModelTest {
    LeepModel lM = new LeepModel();

    @Test
    public void testGetCategoryList () throws Exception {
        String categoryListItem1 = lM.getCategoryList().get(0);
        assertTrue(categoryListItem1.equals(lM.getCategory1()));

        String categoryListItem2 = lM.getCategoryList().get(1);
        assertTrue(categoryListItem2.equals(lM.getCategory2()));

        String categoryListItem3 = lM.getCategoryList().get(2);
        assertTrue(categoryListItem3.equals(lM.getCategory3()));
    }

    @Test
    public void userInfo () throws  Exception {
        UserModel uM = new UserModel("Sven", "sven@gmail.se", "svenslosenord");

        lM.register(uM);

        assertTrue(lM.getUsername().equals("Sven"));
        assertTrue(lM.getEmail().equals("sven@gmail.se"));
        assertTrue(lM.getPassword().equals("svenslosenord"));
    }

    @Test
    public void testQuotes () throws Exception {
        lM.setQuote1("You are awesome");
        assertTrue(lM.getQuote1().equals("You are awesome"));

        lM.setQuote2("You are more awesome");
        assertTrue(lM.getQuote2().equals("You are more awesome"));

        lM.setQuote3("You are the most awesome");
        assertTrue(lM.getQuote3().equals("You are the most awesome"));
    }
}
