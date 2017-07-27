package edu.chl.leep.ctrl;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import edu.chl.leep.adapter.ExpandableListAdapter;
import com.example.linneabark.test.R;
import edu.chl.leep.utils.ShowCategoryPopUp;
import edu.chl.leep.utils.ShowHelpPopUp;
import edu.chl.leep.utils.ShowQuotesPopUp;
import edu.chl.leep.model.SettingsModel;

/**
 * A simple {@link Fragment} subclass.
 *
 * Class the shows an expandablelistview and controls its popups
 */
public class SettingsController extends Fragment{

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private String buttonTag;
    private ImageButton popUpButton;
    private SettingsModel settingsModel;
    private ShowCategoryPopUp popUpCategory;
    private ShowQuotesPopUp popUpQuote;
    private ShowHelpPopUp popUpHelp;


    public SettingsController() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        settingsModel = new SettingsModel();
        settingsModel.initData();
        listView = (ExpandableListView) rootView.findViewById(R.id.lvExp);
        listAdapter = new ExpandableListAdapter(getActivity(), settingsModel.getListDataHeader(), settingsModel.getListHash(), listView);
        listView.setAdapter(listAdapter);

       return rootView;
    }

    //Decides which popup to show
    public void choosePopUp(View v){
        popUpButton = (ImageButton) v.findViewById(R.id.list_item_button);
        buttonTag = popUpButton.getTag().toString();
        popUpCategory = new ShowCategoryPopUp();
        popUpQuote = new ShowQuotesPopUp();
        popUpHelp = new ShowHelpPopUp();

        if (getExpanded() == 1){
            popUpCategory.showCategoryPopUp(getContext(), getActivity(), buttonTag);
        }else if(getExpanded() == 2){
            popUpQuote.showQuotesPopUp(getContext(), getActivity(), buttonTag);
        }else{
            popUpHelp.showHelpPopUp(getActivity());
        }
    }

    //Returns which groups is expanded
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
