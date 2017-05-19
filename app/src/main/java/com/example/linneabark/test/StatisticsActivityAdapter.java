package com.example.linneabark.test;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Evelina on 2017-05-16.
 */

public class StatisticsActivityAdapter extends RecyclerView.Adapter<StatisticsActivityAdapter.ViewHolder>{

    private int recyclerItemIndex = 0;
    Context context;
    private String [] activity;


    public StatisticsActivityAdapter (Context context, String [] monthsList) {
        this.context = context;
        activity = monthsList;
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
        ((ViewHolder)holder).txtActivity.setText(activity[position]);

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
            //example beneath
            //holder.btn.setBackgroundColor(Color.parseColor("#ffffff"));
        } else {
            holder.txtActivity.setBackgroundColor(Color.WHITE);
        }
    }

    @Override
    public int getItemCount() {
        return activity.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtActivity;
        public ViewHolder(View v){
            super(v);
            txtActivity = (TextView) itemView.findViewById(R.id.txtActivity);
        }

    }
}
