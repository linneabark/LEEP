package edu.chl.leep.model;

import android.app.Activity;
import android.widget.TextView;

import org.w3c.dom.Text;

import edu.chl.leep.ctrl.TimeLog;
import edu.chl.leep.utils.SaveDate;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

/**
 * Created by Eli on 2017-05-04.
 */

public class Time {
    private static Time instance; //CC vill att den deklareras till new Time();
    private long value;
    private Timer timer;
    private long lastTime;
    private static Activity mainActivity;
    private static TextView time_txt;

    private Time(){
        value = 0;
        timer = new Timer();
    }

    //use this if a textview must be manipulated
    public static Time getInstance(Activity activity, TextView txt){
        if(instance == null){
            instance = new Time();
        }
        mainActivity = activity;
        time_txt = txt;
        return instance;
    }

    //use this if you don't care about a text being updated
    public static Time getInstance(Activity activity){
        if(instance == null){
            instance = new Time();
        }
        mainActivity = activity;
        return instance;
    }

    private class UpdateTimeTask extends TimerTask {
        @Override
        public void run() {
            SaveDate sd = new SaveDate();
            updateText(sd.calculateTimeToString(value));
            instance.incTime();
        }
    }

    public void startTimer(){
        value = 0;
        timer.cancel();
        timer = new Timer();
        timer.schedule(new UpdateTimeTask(),0,1000);
    }

    public void stopTimer(){
        lastTime = value;
        value = 0;
        updateText(instance.toString());
        timer.cancel();
        //timer = new Timer();
    }

    private void incTime(){
        value = value + 1000;
    }

    private void decTime() {
        value = value - 1000;
    }

    public String toString(){
        SaveDate sd = new SaveDate();
        return sd.calculateTimeToString(value);
    }

    public long getTime(){
        return value;
    }
    public long getLastTime(){return lastTime;}

    public void updateText(final String text) {
        if(time_txt != null) {
            mainActivity.runOnUiThread(new Runnable() {
                public void run() {
                    time_txt.setText(text);

                }
            });
        }
    }
}
