package edu.chl.leep.model;

import android.app.Activity;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;
import edu.chl.leep.utils.ConvertUtils;

/**
 * Created by Paulina Palmberg on 2017-05-28.
 */

public class CountDown {
    private static CountDown instance;
    private Timer timer;
    private long total;
    private static Activity mainActivity;
    private static TextView timeText;

    public CountDown(long total) {
        this.total = total;
        timer = new Timer();
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
        timer.cancel();
        timer = new Timer();
        timer.schedule(new Update(),0,1000);
    }

    public void stopTimer() {
        System.out.println("Kommer till Stop Timer");
        timer.cancel();
        total = 0;
        updateText(timeToString());
        instance = null;
    }

    private class Update extends TimerTask {
        @Override
        public void run() {
            updateText(timeToString());
            instance.decTime();

        }
    }

    private void decTime() {
        if (total == 0 || total < 0) {
            stopTimer();
            return;
        }
        total = total - 1000;
    }

    private String timeToString() {
        ConvertUtils sd = new ConvertUtils();
        return sd.calculateTimeToString(total);
    }

    private void updateText(final String text) {
        if(timeText != null) {
            mainActivity.runOnUiThread(new Runnable() {
                public void run() {
                    timeText.setText(text);
                }
            });
        }
    }
}