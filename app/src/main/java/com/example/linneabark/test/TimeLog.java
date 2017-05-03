package com.example.linneabark.test;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.linneabark.test.R.id.list;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimeLog extends Fragment {

    private Thread chronoThread;
    TextView time_txt;
    public static int numberOfThreads = 0;

    private long tlStartTime;
    private long tlStopTime;

    public TimeLog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_time_log, container, false);

        //trying to make clock with threads

        // Inflate the layout for this fragment

        Button stopClock = (Button) rootView.findViewById(R.id.stopClock_btn);
        Button startClock = (Button) rootView.findViewById(R.id.startClock_btn);
        time_txt = (TextView) rootView.findViewById(R.id.clock_txt);

        final Chronometer ch = new Chronometer(this);

        startClock.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                chronoThread = new Thread(ch);

                System.out.println(chronoThread.isAlive());

                if(!chronoThread.isAlive()) {

                    tlStartTime = System.currentTimeMillis();

                    chronoThread.start();
                    ch.start();

                    String a = "hej";
                    String b = "beh";

                    //SavedData.list.add(SaveDate.calculateTimeToString(tlStartTime),(a),(b));

                    numberOfThreads++;
                }
            }
        });

        stopClock.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                System.out.println(chronoThread.isAlive());

                if(chronoThread.isAlive()) {

                    tlStopTime = System.currentTimeMillis();
                    ch.stop();
                    numberOfThreads--;
                }

            }
        });


        return rootView;


    }


    public void updateTimerText(final String time) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

                time_txt.setText(time);
                System.out.println(time);
                System.out.println(numberOfThreads);
            }
        });
    }




}


