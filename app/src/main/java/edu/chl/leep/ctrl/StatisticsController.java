package edu.chl.leep.ctrl;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.chl.leep.model.StatisticsModel;
import edu.chl.leep.utils.FindWhichMonth;
import com.example.linneabark.test.R;

import android.widget.Button;

import com.example.linneabark.test.StatisticsActivityAdapter;
import com.example.linneabark.test.StatisticsDateAdapter;
import com.example.linneabark.test.StatisticsMonthAdapter;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 *
 * A controller class which are making the view look at it is supposed to be.
 */
public class StatisticsController extends Fragment {
    private FindWhichMonth findWhichMonth;
    private MainActivityController mainActivity;
    private StatisticsModel statisticsModel;

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

    public StatisticsController() {
        // Required empty public constructor
    }

    public void hej() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_statistics, container, false);

        findWhichMonth = new FindWhichMonth();
        mainActivity = new MainActivityController();
        statisticsModel = new StatisticsModel();

        statisticsActivityAdapter  = new StatisticsActivityAdapter(statisticsModel.reformListToDisplay());
        statisticsDateAdapter = new StatisticsDateAdapter(statisticsModel.getAllDays(), statisticsActivityAdapter);
        statisticsMonthAdapter = new StatisticsMonthAdapter(findWhichMonth.months, statisticsDateAdapter);

        recyclerMonth = (RecyclerView) rootview.findViewById(R.id.recyclerMonth);
        recyclerMonth.setLayoutManager(new LinearLayoutManager(mainActivity.getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerMonth.setAdapter(statisticsMonthAdapter);

        recyclerDate = (RecyclerView) rootview.findViewById(R.id.recyclerDate);
        recyclerDate.setLayoutManager(new LinearLayoutManager(mainActivity.getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerDate.setAdapter(statisticsDateAdapter);

        btnDay = (Button) rootview.findViewById(R.id.btnDay);
        btnMonth = (Button) rootview.findViewById(R.id.btnMonth);

        btnDay.setBackgroundColor(Color.LTGRAY);

        btnDay.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                doButtonsWhite();
                giveButtonColor(v,btnDay);
                statisticsModel.setWhichBtn("btnDay");
            }
        });

        btnMonth.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                doButtonsWhite();
                giveButtonColor(v,btnMonth);
                statisticsModel.setWhichBtn("btnMonth");
            }
        });

        recyclerActivity = (RecyclerView) rootview.findViewById(R.id.recyclerActivity);
        recyclerActivity.setLayoutManager(new LinearLayoutManager(mainActivity.getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerActivity.setAdapter(statisticsActivityAdapter);

        insertCategoryPieChart(statisticsModel.getTotalOfCategoryList());
        insertTotalTimePieChart(statisticsModel.getTotalTimeList());

        pieChart = (PieChart) rootview.findViewById(R.id.pieChart);
        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(50f);
        pieChart.setCenterText("Activity in percent");
        pieChart.setCenterTextSize(10);

        addDataToChart(pieChart);

        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                int pos = e.toString().indexOf("y: ");
                String precent = e.toString().substring(pos + 3);
                for (int i = 0; i < yvalue.length; i++) {
                    if (yvalue[i] == Float.parseFloat(precent)) {
                        pos = i;
                        break;
                    }
                }

                String whichCategory = xcategory[pos];

                //För att skriva ut det snyggt...
                //För att få flera rader, lägg till "\n" där det önskas
                // Toast.makeText(mainActivity.getContext(), ("" + whichCategory + ": " + precent + " %."), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected() {}
        });

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
        xcategory = new String [statisticsModel.getTotalOfCategoryList().size()];
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
}