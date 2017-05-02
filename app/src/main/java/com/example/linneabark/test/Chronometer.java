package com.example.linneabark.test;

import android.content.Context;

/**
 * Created by Eli on 2017-04-24.
 */

public class Chronometer implements Runnable {

    public static final long MILLIS_TO_MINUTES = 60000;
    public static final long MILLIS_TO_HOURS = 3600000;


    private TimeLog timeLog;
    private long tlStartTime;

    private boolean tlIsRunning;

    public Chronometer(TimeLog timeLog){
        this.timeLog = timeLog;
    }

    public void start(){
        tlStartTime = System.currentTimeMillis();
        tlIsRunning = true;

    }

    public void stop(){
        tlIsRunning = false;

    }

    private long oldTime;

    @Override
    public void run(){
        oldTime = 0;
        while(tlIsRunning){

            long since = System.currentTimeMillis() - tlStartTime;
            int seconds = (int) ((since / 1000) % 60);
            int minutes = (int) ((since / MILLIS_TO_MINUTES) % 60);
            int hours = (int) ((since / MILLIS_TO_HOURS) % 24);

            if(oldTime != seconds) {

                oldTime = seconds;

                timeLog.updateTimerText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
            }

        }
    }

}
