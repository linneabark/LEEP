package edu.chl.leep.model;
import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by linneabark on 2017-05-27.
 *
 * A model class which contains the data shown in Settings expandablelistview
 */

public class SettingsModel {

    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;
    private Context context;

    public SettingsModel(Context context){
        this.context = context;
    }

    //Method that adds groups and children in the expandablelistview
    public void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("CATEGORIES");
        listDataHeader.add("QUOTES");
        listDataHeader.add("HELP");

        List<String> category = new ArrayList<>();
        category.add(LeepModel.getCategory1(context));
        category.add(LeepModel.getCategory2(context));
        category.add(LeepModel.getCategory3(context));

        List<String> quote = new ArrayList<>();
        quote.add(LeepModel.getQuote1(context));
        quote.add(LeepModel.getQuote2(context));
        quote.add(LeepModel.getQuote3(context));

        List<String> help = new ArrayList<>();
        help.add("Info om hur appen fungerar");

        listHash.put(listDataHeader.get(0), category);
        listHash.put(listDataHeader.get(1), quote);
        listHash.put(listDataHeader.get(2), help);
    }

    public List getListDataHeader(){
        return listDataHeader;
    }

    public HashMap getListHash(){
        return listHash;
    }
}
