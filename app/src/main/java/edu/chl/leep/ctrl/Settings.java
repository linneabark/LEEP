package edu.chl.leep.ctrl;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.linneabark.test.ExpandableListAdapter;
import com.example.linneabark.test.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.chl.leep.model.Leep;
import edu.chl.leep.service.IQuotesService;
import edu.chl.leep.service.QuotesService;

/**
 * A simple {@link Fragment} subclass.
 */
public class Settings extends Fragment{

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;
    private EditText categoryEdit;
    private IQuotesService iqs;


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
        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listHash, listView);
        listView.setAdapter(listAdapter);
        System.out.println("Listview, sett: " + listView);

       return rootView;
    }

    public void choosePopUp(){

        if (getExpanded() == 1){
            showCategoryPopUp();
        }else if(getExpanded() == 2){
            showQuotesPopUp();
        }else{
            showHelpPopUp();
        }
    }

    private void showCategoryPopUp(){

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View categoryLayout = inflater.inflate(R.layout.pop_up_category, null);
        helpBuilder.setView(categoryLayout);

        
        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
    }


    private void showQuotesPopUp() {

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder((getActivity()));
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View quotesLayout = inflater.inflate(R.layout.pop_up_quotes, null);
        helpBuilder.setView(quotesLayout);

        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
    }

    private void showHelpPopUp() {

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View helpLayout = inflater.inflate(R.layout.pop_up_help, null);
        helpBuilder.setView(helpLayout);

        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
    }

    public int getExpanded(){

        if (listView.isGroupExpanded(0)){
            return 1;
        }else if (listView.isGroupExpanded(1)){
            return 2;
        }else if(listView.isGroupExpanded(2)){
            return 3;
        }
        return 0;

    }


        //method that adds headers and items in the expandablelistview
    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();
        iqs = new QuotesService();

        listDataHeader.add("CATEGORIES");
        listDataHeader.add("QUOTES");
        listDataHeader.add("HELP");

        List<String> category = new ArrayList<>();
        category.add(Leep.getCategory1(getContext()));
        category.add(Leep.getCategory2(getContext()));
        category.add(Leep.getCategory3(getContext()));

        List<String> quote = new ArrayList<>();
        quote.add(iqs.getQuote());
        quote.add(iqs.getQuote());
        quote.add(iqs.getQuote());
        quote.add(iqs.getQuote());

        List<String> help = new ArrayList<>();
        help.add("Massa hjälpinfo");


        listHash.put(listDataHeader.get(0), category);
        listHash.put(listDataHeader.get(1), quote);
        listHash.put(listDataHeader.get(2), help);
    }


}
