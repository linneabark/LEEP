package edu.chl.leep.ctrl;

import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import edu.chl.leep.model.ActivityRow;
import edu.chl.leep.model.Leep;
import edu.chl.leep.model.TimeLogModel;
import edu.chl.leep.service.QuotesService;

import com.example.linneabark.test.Convert;
import com.example.linneabark.test.R;

import edu.chl.leep.service.SaveActivity;
import edu.chl.leep.utils.ConvertUtils;
import edu.chl.leep.model.Time;



/**
 * A simple {@link Fragment} subclass.
 */
public class TimeLog extends Fragment {
    //TODO TimeLogCtrl

    //TODO gör variablerna private

    private TextView quoteDisplay;
    private QuotesService quote;
    private ConvertUtils convertUtils = new ConvertUtils();

    private long stopActivity;
    private long startActivity;
    private TextView time_txt;

    private Convert convert = new Convert();
    private TimeLogModel timeLogModel;
    private Time time;
    private Context mContext;

    /** Timer variables */ //TODO remove?
    private ImageButton timerButton;
    public TextView txtCountDown;
    private TimePickerDialog.OnTimeSetListener mTimeSetListener; Spinner spinner;
    public int position;

    public TimeLog() {
        // Required empty public constructor
    }


    //TODO make smaller methods
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_time_log, container, false);
        mContext = getActivity();

        timeLogModel = new TimeLogModel();

        timeLogModel.checkCategoryStatus(mContext);
        timeLogModel.checkQuoteStatus(mContext);

        quote = new QuotesService(getContext());

        /**SPINNER **/

        spinner = (Spinner)rootView.findViewById(R.id.spinner);
        ArrayAdapter<String> array = new ArrayAdapter<>(mContext, android.R.layout.simple_spinner_item, Leep.getCategoryList(mContext));
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
        time = Time.getInstance(getActivity(), time_txt);


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

                SaveActivity.addActivity(new ActivityRow(
                        Leep.getUSER(),
                        convertUtils.calculateYearToString(),
                        convertUtils.calculateMonthToString(),
                        convertUtils.calculateDayToString(),
                        convert.longToString(startActivity),
                        convert.longToString(time.getTotalTime()),
                        Leep.getCategory(mContext, getPosition())));

                Toast.makeText(mContext, "Activity saved. Duration: " + convertUtils.calculateTimeToString(time.getTotalTime()), Toast.LENGTH_SHORT).show();

            }
        });

        quoteDisplay.setText(quote.getQuote());

        /** Timer, count down */ //TODO remove??
        // txtTimer = (TextView) rootView.findViewById(R.id.txtTimer);
        txtCountDown = (TextView) rootView.findViewById(R.id.timerText);
        timerButton = (ImageButton) rootView.findViewById(R.id.timerButton);

        timerButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


                TimePickerDialog timePickerDialog = new TimePickerDialog(mContext,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mTimeSetListener, timeLogModel.getHour(), timeLogModel.getMinute(), true);

                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.setTitle("Set time to start count down.");
                timePickerDialog.show();
            }
        });

        mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                /*
                System.out.println("hourofday " + hourOfDay);
                System.out.println("minute " + minute);
                String text = "Hour " + hourOfDay + ", minute " + minute + ".";
                txtTimer.setText(text);
                */

               // time.startCountDown(hourOfDay, minute);
            }
        };

        return rootView;
    }


    public void setPosition(int value){
        position = value;
    }

    public int getPosition(){
        return position;
    }




}