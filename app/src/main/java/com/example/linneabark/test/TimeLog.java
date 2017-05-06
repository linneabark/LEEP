package com.example.linneabark.test;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.Timer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;




/**
 * A simple {@link Fragment} subclass.
 */
public class TimeLog extends Fragment {

    TextView time_txt;

    private String startTime;
    private String stopTime;

    public String getStartTime(){
        String str = null;
        if (str == null){
            str = startTime;
        }

        return str;

    }public String getStopTime(){
        String str = null;
        if (str == null){
            str = stopTime;
        }

        return str;

    }





    private Time time;

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
        final Button startClock = (Button) rootView.findViewById(R.id.startClock_btn);
        time_txt = (TextView) rootView.findViewById(R.id.clock_txt);

        time = Time.getInstance(this);
        updateText(time.toString());

        startClock.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                startTime = SaveDate.calculateTimeToString(System.currentTimeMillis());

                System.out.println(getStartTime());

                time.startTimer();
            }
        });

        stopClock.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                time.stopTimer();
                stopTime = SaveDate.calculateTimeToString(System.currentTimeMillis());
                System.out.println(getStopTime());
            }
        });

        return rootView;


    }



    public void updateText(final String text){
        getActivity().runOnUiThread(new Runnable() {
            public void run(){
                time_txt.setText(text);

            }
        });
    }






}


