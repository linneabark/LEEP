package edu.chl.leep.ctrl;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.chl.leep.model.ActivityObject;
import edu.chl.leep.service.SaveActivityService;
import edu.chl.leep.service.StatisticsDisplayService;
import edu.chl.leep.service.StatisticsService;
import edu.chl.leep.utils.Contexts;
import edu.chl.leep.utils.FindWhichMonth;
import com.example.linneabark.test.R;

import android.widget.Button;

import edu.chl.leep.adapter.StatisticsActivityAdapter;
import edu.chl.leep.adapter.StatisticsDateAdapter;
import edu.chl.leep.adapter.StatisticsMonthAdapter;

import com.github.mikephil.charting.charts.PieChart;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 *
 * A controller class which are making the view look at it is supposed to be.
 */
public class StatisticsController extends Fragment {
    private Button btnDay;
    private Button btnMonth;

    private int year = 0;
    private int month = 0;
    private int day = 0;

    private String whichBtn = "btnDay";
    private String dateBtn;
    private String monthBtn;

    private RecyclerView recyclerMonth;
    private RecyclerView recyclerDate;
    private RecyclerView recyclerActivity;

    private StatisticsActivityAdapter statisticsActivityAdapter;
    private StatisticsDateAdapter statisticsDateAdapter;
    private StatisticsMonthAdapter statisticsMonthAdapter;
    private FindWhichMonth findWhichMonth;
    private StatisticsDisplayService statisticsDisplayService;
    private StatisticsService statisticsService;

    private Context mContext;

    private List <ActivityObject> userActivityList;
    private List <ActivityObject> defaultStatisticList;
    private List <ActivityObject> allActivityRowsForSpecificMonth;

    public StatisticsController() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_statistics, container, false);

        mContext = this.getContext();

        Contexts.setContexts(mContext);

        userActivityList = SaveActivityService.activityRowList;

        defaultStatisticList = new ArrayList<>();
        allActivityRowsForSpecificMonth = new ArrayList<>();

        findWhichMonth = new FindWhichMonth();
        statisticsDisplayService = new StatisticsDisplayService();
        statisticsService = new StatisticsService();

        statisticsActivityAdapter  = new StatisticsActivityAdapter(statisticsDisplayService.reformListToDisplay(this,statisticsService));
        //get the days from the month etc
        statisticsDateAdapter = new StatisticsDateAdapter(statisticsService.getAllDays(this), statisticsActivityAdapter, statisticsDisplayService, this, statisticsService);
        statisticsMonthAdapter = new StatisticsMonthAdapter(statisticsDisplayService.monthsInOrder(this, findWhichMonth), statisticsDateAdapter, statisticsActivityAdapter,
                statisticsService, this, statisticsDisplayService);


        recyclerMonth = (RecyclerView) rootview.findViewById(R.id.recyclerMonth);

        //changed mainActivity.getContext() to mContext
        recyclerMonth.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        recyclerMonth.setAdapter(statisticsMonthAdapter);

        recyclerDate = (RecyclerView) rootview.findViewById(R.id.recyclerDate);
        recyclerDate.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        recyclerDate.setAdapter(statisticsDateAdapter);

        btnDay = (Button) rootview.findViewById(R.id.btnDay);
        btnMonth = (Button) rootview.findViewById(R.id.btnMonth);

        btnDay.setBackgroundColor(Color.LTGRAY);

        btnDay.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                setWhichBtn("btnDay");
            }
        });

        btnMonth.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                setWhichBtn("btnMonth");
            }
        });

        recyclerActivity = (RecyclerView) rootview.findViewById(R.id.recyclerActivity);
        recyclerActivity.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        recyclerActivity.setAdapter(statisticsActivityAdapter);

        return rootview;
    }


    public List<ActivityObject> getDefaultStatisticList () {
        return defaultStatisticList;
    }
    public List<ActivityObject> getAllActivityRowsForSpecificMonth() {
        return allActivityRowsForSpecificMonth;
    }
    public List<ActivityObject> getUserActivityList(){
        return userActivityList;
    }

    public void setDateBtn(String dateBtn) {
        this.dateBtn = dateBtn;
    }
    public void setMonthBtn(String monthBtn) {
        this.monthBtn = monthBtn;
    }
    public void setWhichBtn (String btn) {
        whichBtn = btn;
    }

    public String getDateBtn(){return dateBtn;}
    public String getMonthBtn (){return monthBtn;}
    public String getWhichBtn(){return whichBtn;}

    public int getYear () {
        return  year;
    }
    public int getMonth(){
        return month;
    }
    public int getDay() {
        return day;
    }

    public void setYear(int year){
        this.year = year;
    }
    public void setMonth(int month){
        this.month = month;
    }
    public void setDay(int day){
        this.day = day;
    }
}