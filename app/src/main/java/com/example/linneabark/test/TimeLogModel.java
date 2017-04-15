package com.example.linneabark.test;
import android.support.v7.app.AppCompatActivity;

import static java.lang.System.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Eli on 2017-04-06.
 */

public class TimeLogModel extends AppCompatActivity {

    Date currentDate = new Date();

   public TimeLogModel(Date date){

       String thisDate = currentDate.toString();

   }

    /*private void getTime() {

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(format.format(cal.getTime()));
    }*/


}
