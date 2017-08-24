package edu.chl.leep.model;

import org.junit.Test;

import edu.chl.leep.service.RegisterService;

import static org.junit.Assert.assertEquals;

/**
 * Created by Evelinas on 2017-08-12.
 */

public class RegisterActivityModelTest {

    RegisterService rs = new RegisterService();

    @Test
    public void testComparePasswords () throws Exception {
        boolean notSamePassword = rs.comparePasswords("password", "password11");
        assertEquals(false, notSamePassword);

        boolean samePassword = rs.comparePasswords("password", "password");
        assertEquals(true, samePassword);
    }

    @Test
    public void testCheckEmail () throws Exception {
        boolean trueEmail = rs.checkEmail("greg@gmail.se");
        assertEquals(true, trueEmail);

        boolean falseEmail = rs.checkEmail("greg.gmail.se");
        assertEquals(false, falseEmail);
    }
}
