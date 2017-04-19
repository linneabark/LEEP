package com.example.linneabark.test;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;



/**
 * A simple {@link Fragment} subclass.
 */
public class TimeLog extends Fragment {

    public TimeLog() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_time_log, container, false);

        // Inflate the layout for this fragment

        Button stopActivity = (Button) rootView.findViewById(R.id.stopClock_btn);
        Button startClock = (Button) rootView.findViewById(R.id.startClock_btn);
        final TextView time_txt = (TextView) rootView.findViewById(R.id.clock_txt);

        startClock.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                time_txt.setText(TimeLogModel.time());
            }
        });

        return rootView;

    }
}


