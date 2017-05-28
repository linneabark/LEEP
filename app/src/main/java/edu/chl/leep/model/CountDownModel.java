package edu.chl.leep.model;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Evelina on 2017-05-05.
 */
public class CountDownModel {
    static long time;
    static Timer timer;

    void CountDown () {
        long secs = 90; // Måste Hämta minuterna och sekunderna som blivit valt.
        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        time = secs;// om secs blir en String. Integer.parseInt(secs);

        timer.scheduleAtFixedRate(
                new TimerTask(){public void run() {startCountDown();}},
                delay,
                period);
    }

    private final long startCountDown () {
        if (time == 1) {
            timer.cancel();
        }
        return --time;
    }

    public void updateTimer () {
        //En metod som displayar timerns count down. Rudolf vet hur man gör för hennes stoppur.
    }
}
