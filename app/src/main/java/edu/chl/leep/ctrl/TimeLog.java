package edu.chl.leep.ctrl;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import edu.chl.leep.model.ActivityRow;
import edu.chl.leep.model.Leep;
import edu.chl.leep.service.QuotesService;
import com.example.linneabark.test.R;

import edu.chl.leep.service.SaveActivity;
import edu.chl.leep.service.FileService;
import edu.chl.leep.utils.SaveDate;
import com.example.linneabark.test.unused.CategoryHashMap;

import java.util.List;

import edu.chl.leep.service.AccountDetails;
import edu.chl.leep.model.Time;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimeLog extends Fragment {

    private TextView quoteDisplay;
    private QuotesService quote = new QuotesService();
    private SaveDate saveDate = new SaveDate();
    private TextView testText;
    private String category1 = "Category 1";
    private String category2 = "Category 2";
    private String category3 = "Category 3";


    private long stopActivity;
    private long startActivity;
    private TextView time_txt;
    private CategoryHashMap cHM = new CategoryHashMap();
    SaveActivity saveActivity = new SaveActivity();
    private Time time;
    Context mContext;


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
       if((Leep.getCategory1(mContext).equals("")) && (Leep.getCategory2(mContext).equals(""))
       && (Leep.getCategory3(mContext).equals(""))) {

           Leep.setCategory1(mContext, category1);
           Leep.setCategory2(mContext, category2);
           Leep.setCategory3(mContext, category3);

       }


        spinner = (Spinner)rootView.findViewById(R.id.spinner);
       // ArrayAdapter<String> array = new ArrayAdapter<>(mContext, android.R.layout.simple_spinner_item, categoryList );
      //  array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner.setAdapter(array);

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
                        Leep.getCategory(mContext, getPosition())));

                System.out.println("THIS CATEGORYY????:" + Leep.getCategory(mContext,getPosition()));


                FileService.saveActivityToTxt(Leep.getUsername(mContext), SaveActivity.activityRowList, mContext);

                System.out.println("Which filename: "+ Leep.getUsername(mContext));
                System.out.println("Which filename2: "+ Leep.getUSER());

                List<ActivityRow> list = FileService.getActivityFromTxt(Leep.getUsername(mContext), mContext);

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