package edu.chl.leep.model;

import android.app.Activity;
import android.widget.TextView;
import edu.chl.leep.utils.ConvertUtils;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Eli on 2017-05-04.
 * A class which runs a timer, starts and stops a timertask
 */

public class TimerModel {
    private static TimerModel instance;
    private long value;
    private Timer timer;
    private long totalTime;
    private static Activity mainActivity;
    private static TextView time_txt;

    private TimerModel(){
        value = 0;
        timer = new Timer();
    }

    public static TimerModel getInstance(Activity activity, TextView txt){
        if(instance == null){
            instance = new TimerModel();
        }
        mainActivity = activity;
        time_txt = txt;
        return instance;
    }

    public static TimerModel getInstance(Activity activity){
        if(instance == null){
            instance = new TimerModel();
        }
        mainActivity = activity;
        return instance;
    }

    private class UpdateTimeTask extends TimerTask {
        @Override
        public void run() {
            ConvertUtils sd = new ConvertUtils();
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
        totalTime = value;
        value = 0;
        updateText(instance.toString());
        timer.cancel();
    }

    private void incTime(){
        value = value + 1000;
    }

    public String toString(){
        ConvertUtils sd = new ConvertUtils();
        return sd.calculateTimeToString(value);
    }

    public long getTime(){
        return value;
    }
    public long getTotalTime(){return totalTime;}

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
