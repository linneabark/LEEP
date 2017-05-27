package edu.chl.leep.model;

import android.content.Context;
import android.widget.ExpandableListView;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.chl.leep.ctrl.MainActivity;

/**
 * Created by linneabark on 2017-05-27.
 */

public class SettingsModel {


    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;
    private Context context;

    public SettingsModel(Context context){
        this.context = context;

    }

    //method that adds headers and items in the expandablelistview
    public void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("CATEGORIES");
        listDataHeader.add("QUOTES");
        listDataHeader.add("HELP");

        List<String> category = new ArrayList<>();
        category.add(Leep.getCategory1(context));
        category.add(Leep.getCategory2(context));
        category.add(Leep.getCategory3(context));

        List<String> quote = new ArrayList<>();
        quote.add(Leep.getQuote1(context));
        System.out.println("Quote 1: " +Leep.getQuote1(context));
        quote.add(Leep.getQuote2(context));
        System.out.println("Quote 2: " + Leep.getQuote2(context));
        quote.add(Leep.getQuote3(context));

        List<String> help = new ArrayList<>();
        help.add("Info om hur appen fungerar");


        listHash.put(listDataHeader.get(0), category);
        listHash.put(listDataHeader.get(1), quote);
        listHash.put(listDataHeader.get(2), help);
    }
    
}
