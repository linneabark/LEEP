package edu.chl.leep.ctrl;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.linneabark.test.ExpandableListAdapter;
import com.example.linneabark.test.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import edu.chl.leep.model.Leep;
import edu.chl.leep.service.IQuotesService;
import edu.chl.leep.service.QuotesService;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsController extends Fragment{

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;
    private EditText categoryEdit;
    private EditText quotesEdit;
    private String testString;
    private QuotesService qs;
    private Button exitButtonHelp;
    private Button exitButtonCategory;
    private Button exitButtonQuotes;
    private Button saveButtonCategory;
    private Button saveButtonQuotes;
    private ImageButton testButton;

    public SettingsController() {
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

    public void choosePopUp(View v){
        testButton = (ImageButton) v.findViewById(R.id.list_item_button);
        testString = testButton.getTag().toString();

        if (getExpanded() == 1){
            if(Integer.valueOf(testString) == 0) {
                showCategoryPopUpOne();
            }else if (Integer.valueOf(testString) == 1){
                showCategoryPopUpTwo();
            }else {
                showCategoryPopUpThree();
            }
        }else if(getExpanded() == 2){
            if(Integer.valueOf(testString) == 0) {
                showQuotesPopUpOne();
            }else if(Integer.valueOf(testString) == 1){
                showQuotesPopUpTwo();
            }else{
                showQuotesPopUpThree();
            }
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

    private void showCategoryPopUpThree(){

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View categoryLayout = inflater.inflate(R.layout.pop_up_category, null);
        helpBuilder.setView(categoryLayout);


        final AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();


        categoryEdit = (EditText) categoryLayout.findViewById(R.id.edit_text_category);
        categoryEdit.setText(Leep.getCategory3(getContext()), TextView.BufferType.EDITABLE);

        saveButtonCategory = (Button) categoryLayout.findViewById(R.id.save_button_category);
        saveButtonCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Leep.setCategory3(getContext(), categoryEdit.getText().toString());
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


    private void showQuotesPopUpOne() {

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder((getActivity()));
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View quotesLayout = inflater.inflate(R.layout.pop_up_quotes, null);
        helpBuilder.setView(quotesLayout);

        final AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();

        quotesEdit = (EditText) quotesLayout.findViewById(R.id.edit_text_quotes);
        quotesEdit.setText(Leep.getQuote1(getContext()), TextView.BufferType.EDITABLE);

        saveButtonQuotes = (Button) quotesLayout.findViewById(R.id.save_button_quotes);
        saveButtonQuotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Leep.setQuote1(getContext(), quotesEdit.getText().toString());
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

    private void showQuotesPopUpTwo() {

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder((getActivity()));
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View quotesLayout = inflater.inflate(R.layout.pop_up_quotes, null);
        helpBuilder.setView(quotesLayout);

        final AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();

        quotesEdit = (EditText) quotesLayout.findViewById(R.id.edit_text_quotes);
        quotesEdit.setText(Leep.getQuote2(getContext()), TextView.BufferType.EDITABLE);

        saveButtonQuotes = (Button) quotesLayout.findViewById(R.id.save_button_quotes);
        saveButtonQuotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Leep.setQuote2(getContext(), quotesEdit.getText().toString());
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

    private void showQuotesPopUpThree() {

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder((getActivity()));
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View quotesLayout = inflater.inflate(R.layout.pop_up_quotes, null);
        helpBuilder.setView(quotesLayout);

        final AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();

        quotesEdit = (EditText) quotesLayout.findViewById(R.id.edit_text_quotes);
        quotesEdit.setText(Leep.getQuote3(getContext()), TextView.BufferType.EDITABLE);

        saveButtonQuotes = (Button) quotesLayout.findViewById(R.id.save_button_quotes);
        saveButtonQuotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Leep.setQuote3(getContext(), quotesEdit.getText().toString());
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
        qs = new QuotesService();

        listDataHeader.add("CATEGORIES");
        listDataHeader.add("QUOTES");
        listDataHeader.add("HELP");

        List<String> category = new ArrayList<>();
        category.add(Leep.getCategory1(getContext()));
        category.add(Leep.getCategory2(getContext()));
        category.add(Leep.getCategory3(getContext()));

        List<String> quote = new ArrayList<>();
        quote.add(Leep.getQuote1(getContext()));
        System.out.println("Quote 1: " +Leep.getQuote1(getContext()));
        quote.add(Leep.getQuote2(getContext()));
        System.out.println("Quote 2: " + Leep.getQuote2(getContext()));
        quote.add(Leep.getQuote3(getContext()));

        List<String> help = new ArrayList<>();
        help.add("Info om hur appen fungerar");


        listHash.put(listDataHeader.get(0), category);
        listHash.put(listDataHeader.get(1), quote);
        listHash.put(listDataHeader.get(2), help);
    }



}
