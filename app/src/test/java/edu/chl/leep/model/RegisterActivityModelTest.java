package edu.chl.leep.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Evelinas on 2017-08-12.
 */

public class RegisterActivityModelTest {

    RegisterActivityModel rAM = new RegisterActivityModel();

    @Test
    public void testComparePasswords () throws Exception {
        boolean notSamePassword = rAM.comparePasswords("password", "password11");
        assertEquals(false, notSamePassword);

        boolean samePassword = rAM.comparePasswords("password", "password");
        assertEquals(true, samePassword);
    }

    @Test
    public void testCheckEmail () throws Exception {
        boolean trueEmail = rAM.checkEmail("greg@gmail.se");
        assertEquals(true, trueEmail);

        boolean falseEmail = rAM.checkEmail("greg.gmail.se");
        assertEquals(false, falseEmail);
    }
}
