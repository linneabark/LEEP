package com.example.linneabark.test;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Settings extends Fragment {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap <String, List<String>> listHash;


    public Settings() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        final Button showPopUp = (Button) rootView.findViewById(R.id.buttonShowPopUp);
        showPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSimplePopUp();
            }
        });

        listView = (ExpandableListView) rootView.findViewById(R.id.lvExp);
        initData();
        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listHash);
        listView.setAdapter(listAdapter);

       return rootView;
    }

    private void showSimplePopUp(){
        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(getActivity());
        helpBuilder.setTitle("Pop Up");
        helpBuilder.setMessage("This is a PopUp");
        helpBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Do nothing but close the dialog
            }
        });

        helpBuilder.setNegativeButton("Negative", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Do nothing
            }
        });

        helpBuilder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Do nothing
            }
        });


        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();


    }


        //method that adds headers and items in the expandablelistview
    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("CATEGORIES");
        listDataHeader.add("TIMER");
        listDataHeader.add("QUOTES");
        listDataHeader.add("ACTIVITIES");
        listDataHeader.add("HELP");

        List<String> category = new ArrayList<>();
        category.add("Category 1");
        category.add("Category 2");
        category.add("Category 3");
        category.add("Category 4");
        category.add("Category 5");

        List<String> timer = new ArrayList<>();
        timer.add("Skriver lite har");
        timer.add("Kanske en del har");
        timer.add("Hoppas det funkar");
        timer.add("Orkar inte mer");


        List<String> quote = new ArrayList<>();
        quote.add("blahahahah");
        quote.add("bläääää");
        quote.add("trött");
        quote.add("orkar inteeeeeee");

        List<String> activity = new ArrayList<>();
        activity.add("ett");
        activity.add("sista");
        activity.add("jävla");
        activity.add("försök");

        List<String> help = new ArrayList<>();
        help.add("japp");
        help.add("det funkar");


        listHash.put(listDataHeader.get(0), category);
        listHash.put(listDataHeader.get(1), timer);
        listHash.put(listDataHeader.get(2), quote);
        listHash.put(listDataHeader.get(3), activity);
        listHash.put(listDataHeader.get(4), help);
    }

}
