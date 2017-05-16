package com.example.linneabark.test;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by linneabark on 2017-05-06.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listDataHeaderCategory;
    private List<String> listDataHeaderTimer;
    private List<String> listDataHeaderQuotes;
    private List<String> listDataHeaderHelp;
    private HashMap<String, List<String>> listHashCategory;
    private HashMap<String, List<String>> listHashTimer;
    private HashMap<String, List<String>> listHashQuotes;
    private HashMap<String, List<String>> listHashHelp;

    public ExpandableListAdapter (Context context, List <String> listDataHeaderCategory,List <String> listDataHeaderTimer, List <String> listDataHeaderQuotes, List <String> listDataHeaderHelp, HashMap <String, List<String>> listHashCategory,HashMap <String, List<String>> listHashTimer,HashMap <String, List<String>> listHashQuotes,HashMap <String, List<String>> listHashHelp ){
        this.context = context;
        this.listDataHeaderCategory=listDataHeaderCategory;
        this.listDataHeaderTimer=listDataHeaderTimer;
        this.listDataHeaderQuotes=listDataHeaderQuotes;
        this.listDataHeaderHelp=listDataHeaderHelp;
        this.listHashCategory=listHashCategory;
        this.listHashTimer=listHashTimer;
        this.listHashQuotes=listHashQuotes;
        this.listHashHelp=listHashHelp;
        
    }

    @Override
    public int getGroupCount() {
        return listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listHashMap.get(listDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listHashMap.get(listDataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        final String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_group, null);
        }
        TextView lblListHeader = (TextView) convertView.findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition, childPosition);
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);
        }
        TextView textListChild = (TextView) convertView.findViewById(R.id.lblListItem);
        textListChild.setText(childText);


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
