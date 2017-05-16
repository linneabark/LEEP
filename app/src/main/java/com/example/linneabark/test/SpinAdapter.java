package com.example.linneabark.test;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Eli on 2017-05-12.
 */

public class SpinAdapter extends ArrayAdapter<CategoryHashMap> {

    private Context mContext;

    private CategoryHashMap[] values;

    // Your sent context
    // Your custom values for the spinner (User)


    public SpinAdapter(Context mContext, int textViewResourceId, CategoryHashMap[] values) {
        super(mContext, textViewResourceId, values);
        this.mContext = mContext;
        this.values = values;
    }

    public int getCount() { //number of element in the spinner
        return values.length;
    }

    public CategoryHashMap getItem(int position){
        return values[position];}

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(mContext);
        label.setTextColor(Color.BLACK);

        label.setText(values[position].getName(0));

        return label;

    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent){
        TextView label = new TextView(mContext);
        label.setTextColor(Color.BLACK);
        label.setText(values[position].getName(0));

        return label;

}
}
