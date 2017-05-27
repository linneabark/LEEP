package com.example.linneabark.test;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Evelina on 2017-05-12.
 */

public class StatisticsMonthAdapter extends RecyclerView.Adapter<StatisticsMonthAdapter.ViewHolder> {
    Context context;
    private String [] months;


    public StatisticsMonthAdapter (Context context, String [] monthsList) {
        this.context = context;
        months = monthsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //is used to inflate the layout for your list item.
        //TextView view = (TextView)LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
        LayoutInflater inflater  = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.costume_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(row);
        return viewHolder;
    }

    int recyclerItemIndex = 0;
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //configures your layouts for the list item (e.g. setting text to a TextView)
        //holder.mTextView.setText(months[position]);
        ((ViewHolder)holder).btn.setText(months[position]);

        //Direkt kopiering till statisticsDateAdapter
        holder.btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                recyclerItemIndex = position;
                notifyDataSetChanged();
                monthOfBtn = position;
            }
        });

        if(recyclerItemIndex==position) {
            holder.btn.setBackgroundColor(Color.LTGRAY);
            //example beneath
            //holder.btn.setBackgroundColor(Color.parseColor("#ffffff"));
        } else {
            holder.btn.setBackgroundColor(Color.WHITE);
        }
    }

    @Override
    public int getItemCount() {
        return months.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button btn;
        public ViewHolder(View v){
            super(v);
            btn = (Button) itemView.findViewById(R.id.item);
        }

    }
    private int monthOfBtn;
    public String getMonthOfBtn () {
        return months[monthOfBtn];
    }
}
