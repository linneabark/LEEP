package com.example.linneabark.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class Statistics extends Fragment {
    private SaveActivity saveActivity = new SaveActivity();

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

    private boolean whichMonth (int i) {
        if (listViewMonth.getText().equals(saveActivity.activityRowList.get(i).getMonth())) {

        }
    }

    //vi börjar med day. när man väljer dag under statistic.
    //då är en månad vald och då skall endast dagarna som månaden är kunna väljas.
    public void findSpecifikDay() {
        for(int i= 0; i < saveActivity.activityRowList.size(); i++ ){
            if (listViewMonth.getText().equals)

        }


    }
}
