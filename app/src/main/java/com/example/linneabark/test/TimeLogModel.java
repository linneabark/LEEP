package com.example.linneabark.test;
import static java.lang.System.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import android.support.v7.app.AppCompatActivity;

import static java.lang.System.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;

/**
 * Created by Eli on 2017-04-06.
 */


public class TimeLogModel extends TimeLog {

    static Date currentDate = new Date();

   public TimeLogModel(){



   }

   static String time(){

       Date currentDate = new Date();

       DateFormat df = new SimpleDateFormat("HH:mm:ss");
       String outText = df.format(currentDate);

       return outText;
   }

    /*private void getTime() {

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(format.format(cal.getTime()));
    }*/


}
