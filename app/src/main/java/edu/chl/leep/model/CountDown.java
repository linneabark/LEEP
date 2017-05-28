package edu.chl.leep.model;

import android.app.Activity;
import android.widget.TextView;

import com.example.linneabark.test.R;

import java.util.Timer;
import java.util.TimerTask;

import edu.chl.leep.ctrl.TimeLog;
import edu.chl.leep.utils.ConvertUtils;

/**
 * Created by Paulina Palmberg on 2017-05-28.
 */

public class CountDown {

    private static CountDown instance;
    private Timer timer;
    private long total; // totaltid för timer
    private static Activity mainActivity;
    private static TextView timeText;

    TimeLog timeLog;

    public CountDown(long total) {
        this.total = total;
    }

    public static CountDown getInstance(Activity activity, TextView txt, long total) {
        if(instance == null){
            instance = new CountDown(total);
        }
        mainActivity = activity;
        timeText = txt;
        return instance;
    }

    public void startCountDown() {
//        System.out.println("Jag kommer till startCountDown!!");
//        timer.cancel();
        timer = new Timer();
        timer.schedule(new Update(),0,1000);
    }


    private class Update extends TimerTask {
        @Override
        public void run() {
            // timeLog = new TimeLog();
            System.out.println("Jag kommer till run()!!");
            System.out.println("Tid: " + timeToString());
            if (total == 1000) {
                timer.cancel();
                /** Ska låta så man vet att timern tagit slut!! */
            }
            // timeLog.txtCountDown.setText(timeToString());
            // timeLog.updateTextLabel(timeToString());
            updateText(toString());
            decTime();
        }
    }

    private void decTime() {
        total = total - 1000;
    }

    public String timeToString() {
        System.out.println("toString");
        ConvertUtils sd = new ConvertUtils();
        return sd.calculateTimeToString(total);
    }

    public void updateText(final String text) {
        if(timeText != null) {
            mainActivity.runOnUiThread(new Runnable() {
                public void run() {
                    timeText.setText(text);
                }
            });
        }
    }
}