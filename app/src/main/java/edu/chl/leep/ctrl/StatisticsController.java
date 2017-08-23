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
import edu.chl.leep.model.StatisticsModel;
import edu.chl.leep.service.SaveActivityService;
import edu.chl.leep.service.StatisticService;
import edu.chl.leep.service.StatisticsDisplayService;
import edu.chl.leep.utils.Contexts;
import edu.chl.leep.utils.FindWhichMonth;
import com.example.linneabark.test.R;

import android.widget.Button;

import edu.chl.leep.adapter.StatisticsActivityAdapter;
import edu.chl.leep.adapter.StatisticsDateAdapter;
import edu.chl.leep.adapter.StatisticsMonthAdapter;
import edu.chl.leep.utils.StatisticsUtils;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 *
 * A controller class which are making the view look at it is supposed to be.
 */
public class StatisticsController extends Fragment {
    private StatisticsUtils statisticsUtils;
    private StatisticService statisticsService;

    private RecyclerView recyclerMonth;
    private RecyclerView recyclerDate;
    private RecyclerView recyclerActivity;


    private Button btnDay;
    private Button btnMonth;
    private PieChart pieChart;
    private float [] yvalue;
    private String [] xcategory;

    private StatisticsActivityAdapter statisticsActivityAdapter;
    private StatisticsDateAdapter statisticsDateAdapter;
    private StatisticsMonthAdapter statisticsMonthAdapter;
    private StatisticsDisplayService statisticsDisplayService;

    Context mContext;

    private FindWhichMonth findWhichMonth;
    private List <ActivityObject> defaultStatisticList;
    private List<ActivityObject> userActivityList;
    private List <ActivityObject> allActivityRowsForSpecificMonth;
    private List<String> totalOfCategoryList;
    private List<Long> totalTimeList;

    private long oldTimeOfActivity = 0;

    public List<ActivityObject> getDefaultStatisticsList(){
        return defaultStatisticList;
    }
    public List<ActivityObject> getUserActivityList(){
        return userActivityList;
    }
    public List<ActivityObject> getAllActivityRowsForSpecificMonth(){
        return allActivityRowsForSpecificMonth;
    }
    public List<String> getTotalOfCategoryList(){
        return totalOfCategoryList;
    }
    public List<Long> getTotalTimeList(){
        return totalTimeList;
    }

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

        defaultStatisticList = new ArrayList<>();
        userActivityList = SaveActivityService.activityRowList;
        allActivityRowsForSpecificMonth = new ArrayList<>();
        totalOfCategoryList = new ArrayList<>();
        totalTimeList = new ArrayList<>();

        findWhichMonth = new FindWhichMonth();
        statisticsService = new StatisticService();
        statisticsDisplayService = new StatisticsDisplayService();




        List<String> hej = new ArrayList<>();
        hej.add("heeej");
        hej.add("pååååå");

        statisticsActivityAdapter = new StatisticsActivityAdapter(statisticsDisplayService.reformListToDisplay(statisticsService));
        statisticsDateAdapter = new StatisticsDateAdapter(statisticsService.getAllDays(), statisticsActivityAdapter);
        statisticsMonthAdapter = new StatisticsMonthAdapter(findWhichMonth.months, statisticsDateAdapter);

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
                doButtonsWhite();
                giveButtonColor(v,btnDay);
                statisticsService.setWhichBtn("btnDay");
            }
        });

        btnMonth.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                doButtonsWhite();
                giveButtonColor(v,btnMonth);
                statisticsService.setWhichBtn("btnMonth");
            }
        });

        recyclerActivity = (RecyclerView) rootview.findViewById(R.id.recyclerActivity);
        recyclerActivity.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        recyclerActivity.setAdapter(statisticsActivityAdapter);

        insertCategoryPieChart(getTotalOfCategoryList());
        insertTotalTimePieChart(getTotalTimeList());

        pieChart = (PieChart) rootview.findViewById(R.id.pieChart);
        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(50f);
        pieChart.setCenterText("Activity in percent");
        pieChart.setCenterTextSize(10);

        addDataToChart(pieChart);

        return rootview;
    }

    private void addDataToChart(PieChart pieChart) {
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();

        for(int i = 0; i < yvalue.length; i++) {
            yEntrys.add(new PieEntry(yvalue[i] , i));
        }
        for(int i = 0; i < xcategory.length; i++) {
            xEntrys.add(xcategory[i]);
        }

        PieDataSet pieDataSet = new PieDataSet(yEntrys, "Activitys precent");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.GRAY);
        colors.add(Color.RED);
        colors.add(Color.CYAN);
        colors.add(Color.MAGENTA);

        pieDataSet.setColors(colors);

        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();

    }

    public void giveButtonColor (View view, Button btn) {
        if (view == btn) {
            btn.setBackgroundColor(Color.LTGRAY);
        }
    }

    public void doButtonsWhite () {
        btnDay.setBackgroundColor(Color.WHITE);
        btnMonth.setBackgroundColor(Color.WHITE);
    }

    public String [] insertCategoryPieChart (List<String> categoryList){
        xcategory = new String [getTotalOfCategoryList().size()];
        for (int i = 0; i < categoryList.size(); i++) {
            xcategory [i] = categoryList.get(i);
        }
        return xcategory;
    }

    public float [] insertTotalTimePieChart (List<Long> totalTimeList){
        yvalue = new float[totalTimeList.size()];
        for (int i = 0; i < totalTimeList.size(); i++) {
            float totalTimeValue = Float.valueOf(totalTimeList.get(i));
            yvalue [i] = totalTimeValue;
        }
        return yvalue;
    }
    //metod för att potionera piecharten
    public void totalForActivity (List<ActivityObject> oneList) {
        long totalTimeOfEveryting = 0;

        for (int i = 0; i < oneList.size(); i++){
            String categoryName = oneList.get(i).getCategoryName();

            long totalTimeOfActivity = oneList.get(i).getTotalTime();

            if (!(totalOfCategoryList.contains(categoryName))) {
                totalOfCategoryList.add(categoryName);
                totalTimeList.add(totalOfCategoryList.indexOf(categoryName),totalTimeOfActivity);
            }
            else {
                int indexOfCategory = totalOfCategoryList.indexOf(categoryName);
                incActivityTotalTime(indexOfCategory, totalTimeOfActivity, totalTimeList.get(indexOfCategory));
            }
            totalTimeOfEveryting = totalTimeOfEveryting + oldTimeOfActivity;
        }
    }

    //For the pieChart
    private void incActivityTotalTime (int indexOfCategory, long totalTimeOfActivity, long oldTime) {
        totalTimeOfActivity = totalTimeOfActivity + oldTime;

        totalTimeList.remove(indexOfCategory);
        totalTimeList.add(indexOfCategory, totalTimeOfActivity);

        oldTimeOfActivity = totalTimeOfActivity;
    }
}