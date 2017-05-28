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
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.linneabark.test.ExpandableListAdapter;
import com.example.linneabark.test.R;
import com.example.linneabark.test.ShowCategoryPopUp;
import com.example.linneabark.test.ShowQuotesPopUp;

import edu.chl.leep.model.Leep;
import edu.chl.leep.model.SettingsModel;
/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsController extends Fragment{

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private EditText categoryEdit;
    private EditText quotesEdit;
    private String buttonTag;
    private Button exitButtonHelp;
    private Button exitButtonCategory;
    private Button exitButtonQuotes;
    private Button saveButtonCategory;
    private Button saveButtonQuotes;
    private ImageButton popUpButton;
    private SettingsModel settingsModel;

    private ShowCategoryPopUp popUpCategory;
    private ShowQuotesPopUp popUpQuote;

    public SettingsController() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        settingsModel = new SettingsModel(getContext());
        settingsModel.initData();
        listView = (ExpandableListView) rootView.findViewById(R.id.lvExp);
        listAdapter = new ExpandableListAdapter(getActivity(), settingsModel.getListDataHeader(), settingsModel.getListHash(), listView);
        listView.setAdapter(listAdapter);
        System.out.println("Listview, sett: " + listView);

       return rootView;
    }

    public void choosePopUp(View v){
        popUpButton = (ImageButton) v.findViewById(R.id.list_item_button);
        buttonTag = popUpButton.getTag().toString();
        popUpCategory = new ShowCategoryPopUp();
        popUpQuote = new ShowQuotesPopUp();

        if (getExpanded() == 1){
            if(Integer.valueOf(buttonTag) == 0) {
                popUpCategory.showCategoryPopUpOne(getContext(), getActivity());
            }else if (Integer.valueOf(buttonTag) == 1){
                popUpCategory.showCategoryPopUpTwo(getContext(), getActivity());
            }else {
                popUpCategory.showCategoryPopUpThree(getContext(), getActivity());
            }
        }else if(getExpanded() == 2){
            if(Integer.valueOf(buttonTag) == 0) {
                popUpQuote.showQuotesPopUpOne(getContext(), getActivity());
            }else if(Integer.valueOf(buttonTag) == 1){
                popUpQuote.showQuotesPopUpTwo(getContext(), getActivity());
            }else{
                popUpQuote.showQuotesPopUpThree(getContext(), getActivity());
            }
        }else{
            showHelpPopUp();
        }
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
}}
