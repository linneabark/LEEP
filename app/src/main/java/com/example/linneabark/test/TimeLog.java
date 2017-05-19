package com.example.linneabark.test;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
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
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.lang.reflect.Array;
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
    private CategoryHashMap cHM = new CategoryHashMap();
    SaveActivity saveActivity = new SaveActivity();
    private Time time;
    Context mContext;
    Category cG = new Category();


    public TimeLog() {
        // Required empty public constructor
    }


    Spinner spinner;


    public int position;

    public void setPosition(int value){
        position = value;

        System.out.println(value);

    }

    public int getPosition(){
        return position;
    }

   /* String[] hej = new String[] {
            cHM.getName(0), cHM.getName(1), cHM.getName(2), cHM.getName(3), cHM.getName(4), cHM.getName(5)
    };*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_time_log, container, false);
        mContext = getActivity();

        /**SPINNER **/

        //check whether or not the categories has been initialized with a name yet, should be in a seperate method
       if(AccountDetails.getCategory1(mContext).equals("") && (AccountDetails.getCategory2(mContext).equals("")
       && (AccountDetails.getCategory3(mContext).equals("")))) {

           String input = "Category ";

           for(int i = 1; i <4; i++){
               AccountDetails.setCategory(mContext, input, i);
           }
       }

       cG.addDefaultCategories(mContext);

       String [] categoryList = new String [cG.categoryList.size()];

       for (int i = 0; i < cG.categoryList.size(); i++) {
           categoryList[i] = cG.categoryList.get(i);
       }

        spinner = (Spinner)rootView.findViewById(R.id.spinner);
        ArrayAdapter<String> array = new ArrayAdapter<>(mContext, android.R.layout.simple_spinner_item, categoryList );
        array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(array);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                //parent.getItemAtPosition(position);

                setPosition(position+1);
                Toast.makeText(mContext,parent.getItemAtPosition(position) + " selected.", Toast.LENGTH_SHORT ).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }


        );

        /**TIMER **/

        quoteDisplay = (TextView) rootView.findViewById(R.id.quoteDisplay);
        Button stopClock = (Button) rootView.findViewById(R.id.stopClock_btn);
        final Button startClock = (Button) rootView.findViewById(R.id.startClock_btn);
        time_txt = (TextView) rootView.findViewById(R.id.clock_txt);
        time = Time.getInstance(this);


        updateText(time.toString());

        startClock.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                time.startTimer();

                startActivity = System.currentTimeMillis();

                Toast.makeText(mContext, "Activity started!", Toast.LENGTH_SHORT).show();

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
                        AccountDetails.getCategory(mContext, getPosition())));

                System.out.println("THIS CATEGORYY????:" + AccountDetails.getCategory(mContext,getPosition()));

                SaveAll.saveActivityToTxt(AccountDetails.getUsername(mContext), SaveActivity.activityRowList, mContext);

                System.out.println("Which filename: "+ AccountDetails.getUsername(mContext));
                System.out.println("Which filename2: "+ AccountDetails.getUSER());

                List<ActivityRow> list = SaveAll.getActivityFromTxt(AccountDetails.getUsername(mContext), mContext);

                System.out.println(list);


                Toast.makeText(mContext, "Activity saved. Duration: " + saveDate.calculateTimeToString(stopActivity - startActivity), Toast.LENGTH_SHORT).show();


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


