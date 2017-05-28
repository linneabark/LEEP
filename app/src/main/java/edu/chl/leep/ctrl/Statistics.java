package edu.chl.leep.ctrl;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import edu.chl.leep.model.ActivityRow;
import edu.chl.leep.model.Leep;
import edu.chl.leep.model.StatisticsModel;
import edu.chl.leep.utils.FindWhichMonth;
import com.example.linneabark.test.R;
import edu.chl.leep.service.SaveActivity;
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
 */
public class Statistics extends Fragment {
    //TODO StatisticsCtrl
    public Statistics() {
        // Required empty public constructor
    }
    private FindWhichMonth findWhichMonth = new FindWhichMonth();

    private static MainActivity mainActivity = new MainActivity();
    private StatisticsModel statisticsModel = new StatisticsModel();

    private RecyclerView recyclerMonth;
    private RecyclerView recyclerDate;
    private RecyclerView recyclerActivity;

    private Button btnDay;
    private Button btnXDays;
    private Button btnMonth;

    private float [] yvalue;
    private String [] xcategory;

    private PieChart pieChart;

    public String [] insertCategoryPieChart (List<String> categoryList){
        xcategory = new String [statisticsModel.getTotalOfCategoryList().size()];
        System.out.println("categprylist size" + categoryList.size());
         for (int i = 0; i < categoryList.size(); i++) {
             xcategory [i] = categoryList.get(i);
         }
        System.out.println("xcategory" + xcategory.length);
         return xcategory;
    }

    public float [] insertTotalTimePieChart (List<Long> totalTimeList){
        yvalue = new float[totalTimeList.size()];
        System.out.println("totaltimelist size" + totalTimeList.size());
        for (int i = 0; i < totalTimeList.size(); i++) {
            float totalTimeValue = Float.valueOf(totalTimeList.get(i));
            System.out.println("totaltimevalue --> "+ totalTimeValue);
            yvalue [i] = totalTimeValue;
        }
        System.out.println("yvalue" + yvalue.length);
        return yvalue;
    }


    public static List<String> date = new ArrayList<>();
    public static List <String> assList () {
        date.add("01");
        date.add("02");
        date.add("03");
        date.add("04");
        date.add("06");
        date.add("07");
        date.add("08");
        date.add("09");
        date.add("10");

        return date;
    }

    StatisticsActivityAdapter statisticsActivityAdapter = new StatisticsActivityAdapter(mainActivity.getContext(),  statisticsModel.reformListToDisplay());
    StatisticsDateAdapter statisticsDateAdapter = new StatisticsDateAdapter(mainActivity.getContext(), assList(), statisticsActivityAdapter);
    StatisticsMonthAdapter statisticsMonthAdapter = new StatisticsMonthAdapter(mainActivity.getContext(), findWhichMonth.months, statisticsDateAdapter);




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_statistics, container, false);
/**/
        //to display the months
        recyclerMonth = (RecyclerView) rootview.findViewById(R.id.recyclerMonth);
        recyclerMonth.setLayoutManager(new LinearLayoutManager(mainActivity.getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerMonth.setAdapter(statisticsMonthAdapter);

        //to display all the dates there where logged in a specific month.
        recyclerDate = (RecyclerView) rootview.findViewById(R.id.recyclerDate);
        recyclerDate.setLayoutManager(new LinearLayoutManager(mainActivity.getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerDate.setAdapter(statisticsDateAdapter);

        btnDay = (Button) rootview.findViewById(R.id.btnDay);
        btnXDays = (Button) rootview.findViewById(R.id.btnXDays);
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
        btnXDays.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                doButtonsWhite();
                giveButtonColor(v,btnXDays);
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

        //The PieChart
        pieChart = (PieChart) rootview.findViewById(R.id.pieChart);
        //set propeties
        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(50f);
        pieChart.setCenterText("Activity in percent");
        pieChart.setCenterTextSize(10);

        addDataToChart(pieChart);

        //pieChart listener så när man trycker på en pajbit så kommer de upp en text.
        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {


                //e.toString().indexOf("(sum) ");man behöver detta pga att programmet skriver ut detta. Inget vi valt.
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

    //behöver ej in-parametern / typ-parametrn när variabeln ligger i denna klassen. Flyttar vi dock ut metoden eller dyligt måste det finnas en in-parameter.
    private void addDataToChart(PieChart pieChart) {
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();

        //Loppar igenom de procentuella värderna och lägger till  yEntry arraylist
        for(int i = 0; i < yvalue.length; i++) {
            yEntrys.add(new PieEntry(yvalue[i] , i));
        }
        //Lägger till categorinamnet i xEntry arraylisten
        for(int i = 0; i < xcategory.length; i++) {
            xEntrys.add(xcategory[i]);
        }

        //skapar the data set

        PieDataSet pieDataSet = new PieDataSet(yEntrys, "Activitys precent");
        //Avståndet mellan de olika pajbitarna
        pieDataSet.setSliceSpace(2);
        //Storleken på den procentuella summan
        pieDataSet.setValueTextSize(12);

        //Lägger till färgerna, koppla ihop dessa med kategorierna
        //add colors to the dataset
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.GRAY);
        colors.add(Color.RED);
        colors.add(Color.CYAN);
        colors.add(Color.MAGENTA);

        pieDataSet.setColors(colors);

        //add legend to the chart. Förklarar hur mann gör allt: https://github.com/PhilJay/MPAndroidChart/wiki/Legend
        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        //create pie data object
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
        btnXDays.setBackgroundColor(Color.WHITE);
        btnMonth.setBackgroundColor(Color.WHITE);
    }

}