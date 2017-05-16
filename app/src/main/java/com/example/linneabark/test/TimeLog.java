package com.example.linneabark.test;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimeLog extends Fragment {

    private TextView quoteDisplay;
    private Quotes quote = new Quotes();
    private SaveDate saveDate = new SaveDate();
    private TextView testText;

    private long stopActivity;
    private long startActivity;
    private TextView time_txt;
    CategoryHashMap cHM = new CategoryHashMap();
    SaveActivity saveActivity = new SaveActivity();
    private Time time;
    Context mContext;


    public TimeLog() {
        // Required empty public constructor
    }

    public void chooseCategory() {
        // ArrayAdapter<String> adapter = ArrayAdapter.createFromResource()
    }


    /*private View.OnTouchListener Spinner_OnTouch = new View.OnTouchListener(){
        public boolean onTouch(View v, MotionEvent event){
            if (event.getAction() == MotionEvent.ACTION_UP){
                // a method

            }
            return true;
        }
    };

    private View.OnKeyListener Spinner_OnKey = new View.OnKeyListener() {
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
                // a method
                return true;
            } else {
                return false;
            }

        }

    };*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_time_log, container, false);


        //Spinner spinner;

        mContext = getActivity();

        /*this.arraySpinner = new String[] {
                "Choose an activity", cHM.getName(0), cHM.getName(1), cHM.getName(2), cHM.getName(3), cHM.getName(4), cHM.getName(5)
        };*/


        //spinner = (Spinner)rootView.findViewById(R.id.spinner);


        //spinner.setOnTouchListener(Spinner_OnTouch);
        //spinner.setOnKeyListener(Spinner_OnKey);


        //trying to make clock with threads

        // Inflate the layout for this fragment
        quoteDisplay = (TextView) rootView.findViewById(R.id.quoteDisplay);
        Button stopClock = (Button) rootView.findViewById(R.id.stopClock_btn);
        final Button startClock = (Button) rootView.findViewById(R.id.startClock_btn);
        time_txt = (TextView) rootView.findViewById(R.id.clock_txt);
        //testText = (TextView) rootView.findViewById(R.id.testText);
        time = Time.getInstance(this);


        updateText(time.toString());

        startClock.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                time.startTimer();

                startActivity = System.currentTimeMillis();

                Toast.makeText(mContext, "Activity started!", Toast.LENGTH_LONG).show();

            }
        });

        stopClock.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                time.stopTimer();

                stopActivity = System.currentTimeMillis();

                saveActivity.addActivity(new ActivityRow(

                        saveDate.calculateYearToString(),
                        saveDate.calculateMonthToString(),
                        saveDate.calculateDayToString(),

                        startActivity,
                        (stopActivity - startActivity),
                        new Category("Föreläsning", 6)));

                //testText.setText(cHM.getName(0));

                System.out.println(cHM.getName(0));

                SaveAll.saveActivityToTxt(AccountDetails.getUsername(mContext), SaveActivity.activityRowList, mContext);


                List<ActivityRow> list = SaveAll.getActivityFromTxt(AccountDetails.getUsername(mContext), mContext);

                System.out.println(list);


                Toast.makeText(mContext, "Activity saved. Duration: " + saveDate.calculateTimeToString(stopActivity - startActivity), Toast.LENGTH_LONG).show();


            }
        });

        quoteDisplay.setText(quote.getQuote());

        return rootView;
    }


    public void updateText(final String text) {
        getActivity().runOnUiThread(new Runnable() {
            public void run() {
                time_txt.setText(text);

            }
        });
    }

}


