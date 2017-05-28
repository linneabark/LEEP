package com.example.linneabark.test;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;


/**
 * Created by Evelina on 2017-05-16.
 */

public class StatisticsActivityAdapter extends RecyclerView.Adapter<StatisticsActivityAdapter.ViewHolder>{

    private int recyclerItemIndex = 0;
    private List <String> activity;


    public StatisticsActivityAdapter (List<String> activityList) {
        activity = activityList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //is used to inflate the layout for your list item.
        LayoutInflater inflater  = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.display_activity,parent,false);
        ViewHolder viewHolder = new ViewHolder(row);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //configures your layouts for the list item (e.g. setting text to a TextView)
        ((ViewHolder)holder).txtActivity.setText(activity.get(position));

        //Direkt kopiering av StatisticsMonthAdapter
        holder.txtActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                recyclerItemIndex = position;
                notifyDataSetChanged();
            }
        });

        if(recyclerItemIndex==position) {
            holder.txtActivity.setBackgroundColor(Color.LTGRAY);
        } else {
            holder.txtActivity.setBackgroundColor(Color.WHITE);
        }
    }

    @Override
    public int getItemCount() {
        return activity.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtActivity;
        private ViewHolder(View v){
            super(v);
            txtActivity = (TextView) itemView.findViewById(R.id.txtActivity);
        }
    }

    public void swapList (List<String> changedList) {
        System.out.println("klass statisticsactivityAdapter, ,etod swapList. Kommer jag hit?");
        System.out.println("vad är date just nu? size är --> " +  activity.size());
        if(activity != null) {
            System.out.println("kommer jag in i if?");
            activity.clear();
            System.out.println("is the clear metod removing? activ ity.size() --> " + activity.size());
            activity.addAll(changedList);
            System.out.println("activity size after if --> " + activity.size());
        } else {
            System.out.println("Eller komme rjag in i else?");
            activity = changedList;
        }
        notifyDataSetChanged();
    }
}
