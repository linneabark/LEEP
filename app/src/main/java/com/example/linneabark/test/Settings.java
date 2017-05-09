package com.example.linneabark.test;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
    private Context context;

    public Settings() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        listView = (ExpandableListView) rootView.findViewById(R.id.lvExp);            //DET ÄR HÄR DEN GER NULLPOINTER
        //System.out.println("Listview: " + listView);
        initData();
        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listHash);
        //System.out.println("listDataHeader: " + listDataHeader);
        //System.out.println("listHash: " + listHash);
        //System.out.println("Aktivitet: " + getActivity().toString());
        listView.setAdapter(listAdapter);

       return rootView;
    }

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


        List<String> qoute = new ArrayList<>();
        qoute.add("blahahahah");
        qoute.add("bläääää");
        qoute.add("trött");
        qoute.add("orkar inteeeeeee");

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
        listHash.put(listDataHeader.get(2), qoute);
        listHash.put(listDataHeader.get(3), activity);
        listHash.put(listDataHeader.get(4), help);
    }

}
