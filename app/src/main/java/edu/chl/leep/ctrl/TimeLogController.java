package edu.chl.leep.ctrl;

import android.content.Context;
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
import android.widget.TextView;
import android.widget.Toast;

import edu.chl.leep.model.ActivityObject;
import edu.chl.leep.model.LeepModel;

import edu.chl.leep.model.TimerModel;
import edu.chl.leep.service.FileService;
import edu.chl.leep.service.QuotesService;

import com.example.linneabark.test.R;

import edu.chl.leep.service.SaveActivity;
import edu.chl.leep.service.UserInfoService;
import edu.chl.leep.utils.Contexts;
import edu.chl.leep.utils.ConvertUtils;


/**
 * A simple {@link Fragment} subclass.
 A controller class which handles the start and stop of the timer*/
public class TimeLogController extends Fragment {

    private TextView quoteDisplay;
    private QuotesService quote;
    private ConvertUtils convertUtils;

    public long stopActivity;
    private long startActivity;
    private TextView time_txt;

    private TimerModel time;
    private FileService fileService;

    private Context mContext;

    Spinner spinner;
    public int position;

    public TimeLogController() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_time_log, container, false);

        mContext = getActivity();
        Contexts.setContexts(mContext);


        fileService = new FileService();
        convertUtils = new ConvertUtils();
        UserInfoService uis = new UserInfoService();

        uis.checkCategoryStatus();
        uis.checkQuoteStatus();

        quote = new QuotesService(getContext());

        /**SPINNER **/
        spinner = (Spinner)rootView.findViewById(R.id.spinner);
        ArrayAdapter<String> array = new ArrayAdapter<>(mContext, android.R.layout.simple_spinner_item, LeepModel.getCategoryList());
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
        time = TimerModel.getInstance(getActivity(), time_txt);

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
                SaveActivity.addActivity(new ActivityObject(
                        LeepModel.getUSER(),
                        convertUtils.calculateYearToString(),
                        convertUtils.calculateMonthToString(),
                        convertUtils.calculateDayToString(),
                        convertUtils.longToString(startActivity),
                        convertUtils.longToString(time.getTotalTime()),
                        LeepModel.getCategory(getPosition())));

                //save the list with SharedPrefs.
                fileService.saveActivityRowListSharedPref(mContext, SaveActivity.activityRowList);

                Toast.makeText(mContext, "Activity saved. Duration: " + convertUtils.calculateTimeToString(time.getTotalTime()), Toast.LENGTH_SHORT).show();
            }
        });

        quoteDisplay.setText(quote.getQuote());

        return rootView;
    }

    public void setPosition(int value){
        position = value;
    }

    public int getPosition(){
        return position;
    }
}