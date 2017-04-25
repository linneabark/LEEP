package com.example.linneabark.test;


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



/**
 * A simple {@link Fragment} subclass.
 */
public class TimeLog extends Fragment {

    private TextView time_txt;
    private Thread chronoThread;

    public TimeLog() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_time_log, container, false);

        //trying to make clock with therads

        // Inflate the layout for this fragment

        Button stopClock = (Button) rootView.findViewById(R.id.stopClock_btn);
        Button startClock = (Button) rootView.findViewById(R.id.startClock_btn);
        time_txt = (TextView) rootView.findViewById(R.id.clock_txt);

        final Chronometer ch = new Chronometer(this);

        startClock.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                chronoThread = new Thread(ch);
                chronoThread.start();
                ch.start();
            }
        });

        stopClock.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                ch.stop();
            }
        });


        return rootView;

    }

   public void updateTimerText(final String time){
       System.out.println(time);
       getActivity().runOnUiThread(new Runnable(){
            @Override
            public void run(){
                time_txt.setText(time);
            }
        });
       //time_txt.setText(time);



   }



}


