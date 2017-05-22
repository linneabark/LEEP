package edu.chl.leep.ctrl;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.linneabark.test.ExpandableListAdapter;
import com.example.linneabark.test.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.chl.leep.model.Leep;
import edu.chl.leep.service.AccountDetails;

/**
 * A simple {@link Fragment} subclass.
 */
public class Settings extends Fragment{

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;


    public Settings() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);

        listView = (ExpandableListView) rootView.findViewById(R.id.lvExp);
        initData();
        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listHash);
        listView.setAdapter(listAdapter);


       return rootView;
    }
/*
    public void showCategoryPopUp(){

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View checkBoxLayout = inflater.inflate(R.layout.pop_up_window_category, null);
        helpBuilder.setView(checkBoxLayout);

        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
    }
    */

        //method that adds headers and items in the expandablelistview
    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("CATEGORIES");
        listDataHeader.add("QUOTES");
        listDataHeader.add("HELP");

        List<String> category = new ArrayList<>();
        category.add(Leep.getCategory1(getContext()));
        category.add(Leep.getCategory2(getContext()));
        category.add(Leep.getCategory3(getContext()));

        List<String> quote = new ArrayList<>();
        quote.add("blahahahah");
        quote.add("bläääää");
        quote.add("trött");
        quote.add("orkar inteeeeeee");

        List<String> help = new ArrayList<>();
        help.add("Massa hjälpinfo");


        listHash.put(listDataHeader.get(0), category);
        listHash.put(listDataHeader.get(1), quote);
        listHash.put(listDataHeader.get(2), help);
    }


}
