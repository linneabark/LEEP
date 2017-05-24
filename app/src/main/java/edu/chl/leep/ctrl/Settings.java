package edu.chl.leep.ctrl;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
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
    //TODO SettingsCtrl

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;
    private EditText categoryEdit;
    private EditText quotesEdit;

    private TextView tv;
    private String string;
   // private IQuotesService iqs;
    private QuotesService qs;
    private Button exitButtonHelp;
    private Button exitButtonCategory;
    private Button exitButtonQuotes;

    private Button saveButtonCategory;
    private Button saveButtonQuotes;




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
            tv = (TextView) listView.findViewById(R.id.lblListItem);
            string = tv.getText().toString();
            System.out.println("String: " + string);
            if(string.equals(Leep.getCategory1(getContext()))){
            showCategoryPopUpOne();
            }else if (string.equals(Leep.getCategory2(getContext()))){
                showCategoryPopUpTwo();
            }

        }else if(getExpanded() == 2){
            showQuotesPopUp();
        }else{
            showHelpPopUp();
        }
    }

    private void showCategoryPopUpOne(){

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View categoryLayout = inflater.inflate(R.layout.pop_up_category, null);
        helpBuilder.setView(categoryLayout);


        final AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();


        categoryEdit = (EditText) categoryLayout.findViewById(R.id.edit_text_category);
        categoryEdit.setText(Leep.getCategory1(getContext()), TextView.BufferType.EDITABLE);

        saveButtonCategory = (Button) categoryLayout.findViewById(R.id.save_button_category);
        saveButtonCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Leep.setCategory1(getContext(), categoryEdit.getText().toString());
                helpDialog.dismiss();

            }
        });

        exitButtonCategory = (Button) categoryLayout.findViewById(R.id.close_button_category);
        exitButtonCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helpDialog.dismiss();
            }
        });
    }

    private void showCategoryPopUpTwo(){

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View categoryLayout = inflater.inflate(R.layout.pop_up_category, null);
        helpBuilder.setView(categoryLayout);


        final AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();


        categoryEdit = (EditText) categoryLayout.findViewById(R.id.edit_text_category);
        categoryEdit.setText(Leep.getCategory2(getContext()), TextView.BufferType.EDITABLE);

        saveButtonCategory = (Button) categoryLayout.findViewById(R.id.save_button_category);
        saveButtonCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Leep.setCategory2(getContext(), categoryEdit.getText().toString());
                helpDialog.dismiss();

            }
        });

        exitButtonCategory = (Button) categoryLayout.findViewById(R.id.close_button_category);
        exitButtonCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helpDialog.dismiss();
            }
        });
    }


    private void showQuotesPopUp() {

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder((getActivity()));
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View quotesLayout = inflater.inflate(R.layout.pop_up_quotes, null);
        helpBuilder.setView(quotesLayout);

        final AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();

        quotesEdit = (EditText) quotesLayout.findViewById(R.id.edit_text_quotes);
        quotesEdit.setText(qs.getQuote1(), TextView.BufferType.EDITABLE);

        saveButtonQuotes = (Button) quotesLayout.findViewById(R.id.save_button_quotes);
        saveButtonQuotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helpDialog.dismiss();

            }
        });


        exitButtonQuotes = (Button) quotesLayout.findViewById(R.id.close_button_quotes);
        exitButtonQuotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helpDialog.dismiss();
            }
        });
    }

    private void showHelpPopUp() {

        final AlertDialog.Builder helpBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View helpLayout = inflater.inflate(R.layout.pop_up_help, null);
        helpBuilder.setView(helpLayout);

        final AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
        exitButtonHelp = (Button) helpLayout.findViewById(R.id.done_button_help);
        exitButtonHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helpDialog.dismiss();
            }
        });
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
        //iqs = new QuotesService();
        qs = new QuotesService();

        listDataHeader.add("CATEGORIES");
        listDataHeader.add("QUOTES");
        listDataHeader.add("HELP");

        List<String> category = new ArrayList<>();
        category.add(Leep.getCategory1(getContext()));
        category.add(Leep.getCategory2(getContext()));
        category.add(Leep.getCategory3(getContext()));

        List<String> quote = new ArrayList<>();
        quote.add(qs.getQuote1());
        quote.add(qs.getQuote2());
        quote.add(qs.getQuote3());

        List<String> help = new ArrayList<>();
        help.add("Info om hur appen fungerar");


        listHash.put(listDataHeader.get(0), category);
        listHash.put(listDataHeader.get(1), quote);
        listHash.put(listDataHeader.get(2), help);
    }


}
