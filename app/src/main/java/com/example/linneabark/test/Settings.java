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

   // private static ListView list_View;
    private static String[] settings = new String[] {"Categories", "Quotes", "Timer", "Help", "Uterus"};

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
        context = getContext();
        System.out.println("Context: " + context);

        listView = (ExpandableListView)getActivity().findViewById(R.id.lvExp);
        initData();
        listAdapter = new ExpandableListAdapter(this.context, listDataHeader, listHash);
        System.out.println("listDataHeader: " + listDataHeader);
        System.out.println("listHash: " + listHash);
        System.out.println("Aktivitet: " + getActivity().toString());
        listView.setAdapter(listAdapter);

       return rootView;
    }

   /* public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        listView = (ExpandableListView)getActivity().findViewById(R.id.lvExp);
        initData();
        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listHash);
        listView.setAdapter(listAdapter);

    }*/

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Linnea");
        listDataHeader.add("Camilla");
        listDataHeader.add("Margareta");
        listDataHeader.add("Bark");

        List<String> linnea = new ArrayList<>();
        linnea.add("This is expandablelistview");

        List<String> camilla = new ArrayList<>();
        camilla.add("Skriver lite har");
        camilla.add("Kanske en del har");
        camilla.add("Hoppas det funkar");
        camilla.add("Orkar inte mer");


        List<String> margareta = new ArrayList<>();
        margareta.add("blahahahah");
        margareta.add("bläääää");
        margareta.add("trött");
        margareta.add("orkar inteeeeeee");

        List<String> bark = new ArrayList<>();
        bark.add("ett");
        bark.add("sista");
        bark.add("jävla");
        bark.add("försök");

        listHash.put(listDataHeader.get(0), linnea);
        listHash.put(listDataHeader.get(1), camilla);
        listHash.put(listDataHeader.get(2), margareta);
        listHash.put(listDataHeader.get(3), bark);
    }

}
