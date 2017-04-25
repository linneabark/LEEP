package com.example.linneabark.test;
import static android.text.format.Time.getCurrentTimezone;
import static java.lang.System.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.content.Context;
import android.os.Handler;

import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.view.View;
import android.widget.Chronometer;

import static java.lang.System.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.util.Timer;
import java.util.logging.LogRecord;

/**
 * Created by Eli on 2017-04-06.
 */


public class TimeLogModel extends TimeLog {

    static Date currentDate = new Date();

    Time nTime;
    Handler handler;
    Runnable r;


    public TimeLogModel(){



   }

   /* public String digitalClock(){
       nTime = new Time();


       Date currentDate = new Date();

       DateFormat df = new SimpleDateFormat("HH:mm:ss");

       r = new Runnable(){
           @Override
           public void run(){
              nTime.setToNow();
               String timee = nTime.getCurrentTimezone();

           }
       };

       handler = new Handler();

       handler.postDelayed(r,1000);

       //DateFormat df = new SimpleDateFormat("HH:mm:ss");
       String outText = .format(currentDate);

       return outText;
   }*/

    /*public class drawingView extends View {

       int hours, minutes, seconds;

       public drawingView(Context context, int hours, int minutes, int seconds){
        super(context);

           this.hours = hours;
           this.minutes = minutes;
           this.seconds = seconds;
       }

       String text = String.format("%02d:%02d:%02d", hours, minutes, seconds );

   }*/

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
