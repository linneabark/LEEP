package edu.chl.leep.model;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by Evelinas on 2017-08-12.
 */

public class LoginActivityModelTest {

    @Test
    public void testUserInfo () throws  Exception {

        LoginActivityModel lAM = new LoginActivityModel();

        UserModel uM = new UserModel("Helga", "Helga", "helga@gmail.se", "helgaspassword");

        boolean userBooleanFalse = lAM.compareUserInfo("Helga", "helgaslosenord"); //The method will return false
        assertEquals(false, userBooleanFalse);

        boolean userBooleanTrue = lAM.compareUserInfo("Helga", "helgaspassword"); //The method will return true
        assertEquals(true, userBooleanTrue);




    }

}
