package com.example.linneabark.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Statistics extends Fragment {


    public Statistics() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_statistics, container, false);
    }

    //skall skapa en metod som hemtar månad och dagar etc..


    private FindWhichMonth findWhichMonth = new FindWhichMonth();
    private SaveActivity saveActivity = new SaveActivity();


    //vi börjar med day. när man väljer dag under statistic.
    //då är en månad vald och då skall endast dagarna som månaden är kunna väljas.
    public void findSpecifikDay() {
        int numberOfMonth = findWhichMonth.numberOfMonth(textMonth.getText());
        String monthInNumber = "";
        if (numberOfMonth > 0 && numberOfMonth < 10) {
            monthInNumber = "0" + numberOfMonth;
        } else if (numberOfMonth >= 10) {
            monthInNumber = "" + numberOfMonth;
        }
        System.out.println("monthInNumber , klassen Statistics: " + monthInNumber);

        //sparar alla datum som finns på den förvalda månaden och skall sedan kunna dispalaya dessa i en lista av något slag.
        List<String> savedatumfordispalilista = new ArrayList<>();

        for(int i= 0; i < saveActivity.activityRowList.size(); i++ ){
            //saveActivity.activityRowList.get(i).getMonth().equals(monthInNumber); <-- kollar vilka som stämmer överrens med månaden.
            if (saveActivity.activityRowList.get(i).getMonth().equals(monthInNumber)) {
                savedatumfordispalilista.add(saveActivity.activityRowList.get(i).getDay());
            }

        }


    }
}
