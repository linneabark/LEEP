package edu.chl.leep.model;

import edu.chl.leep.ctrl.TimeLog;
import edu.chl.leep.utils.SaveDate;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

/**
 * Created by Eli on 2017-05-04.
 */

public class Time {

    private static final long MILLIS_TO_MINUTES = 60;
    private static final long MILLIS_TO_HOURS = 3600;
    private static Time instance; //CC vill att den deklareras till new Time();
    private long value;
    private static TimeLog tL;
    private Timer timer;
    private long lastTime;

    private long timerValue;
    TimeLog timeLog;

    private Time(){
        value = 0;
        timer = new Timer();
    }

    public Time(int hours, int minutes) {
        value = hours * 3600 + minutes * 60;
        timer = new Timer();
    }

    public static Time getInstance(TimeLog timeLog){
        if(instance == null){
            instance = new Time();
        }
        tL = timeLog;
        return instance;
    }

    TimerTask tt;

    public void startTimer(){
        value = 0;
        timer.cancel();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                SaveDate sd = new SaveDate();
                tL.updateText(sd.calculateTimeToString(value));
                instance.incTime();
            }
        },0,1000);
    }

    public void stopTimer(){
        lastTime = value;
        value = 0;
        tL.updateText(instance.toString());
        timer.cancel();
        //timer = new Timer();
    }

    private void incTime(){
        value = value + 1000;
    }

    public void startCountDown(int hours, int minutes) {
        System.out.println("hello");
        instance = new Time(hours, minutes);
        timer.cancel();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (timerValue == 1) {
                    timer.cancel();
                }
                timeLog.txtCountDown.setText(this.toString());
                decTime();
            }
        },0, 1000);
    }

    private void decTime() {
        value = value - 1;
    }

    public String toString(){
        SaveDate sd = new SaveDate();
        return sd.calculateTimeToString(value);
    }

    public long getTime(){
        return value;
    }
    public long getLastTime(){return lastTime;}
}
