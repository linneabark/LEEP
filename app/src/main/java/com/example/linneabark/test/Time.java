package com.example.linneabark.test;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Eli on 2017-05-04.
 */

public class Time {

    public static final long MILLIS_TO_MINUTES = 60;
    public static final long MILLIS_TO_HOURS = 3600;
    private static Time instance;
    private long value;
    private static TimeLog tL;
    private Timer timer;

    private Time(){
        value = 0;
        timer = new Timer();
    }

    public static Time getInstance(TimeLog timeLog){
        if(instance == null){
            instance = new Time();
        }
        tL = timeLog;
        return instance;
    }

    public void startTimer(){
        value = 0;
        timer.cancel();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                tL.updateText(instance.toString());
                System.out.println(instance.toString());
                instance.incTime();
            }
        },0,1000);
    }

    public void stopTimer(){
        timer.cancel();
        timer = new Timer();
    }

    public void incTime(){
        value = value + 1;
    }

    public String toString(){
        //long value = System.currentTimeMillis() - tlStartTime;
        int seconds = (int) ((value % 60));
        int minutes = (int) ((value / MILLIS_TO_MINUTES) % 60);
        int hours = (int) ((value / MILLIS_TO_HOURS)%24);

        return (String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }
}
