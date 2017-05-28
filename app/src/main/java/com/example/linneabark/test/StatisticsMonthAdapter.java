package com.example.linneabark.test;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.chl.leep.model.StatisticsModel;

/**
 * Created by Evelina on 2017-05-12.
 */

public class StatisticsMonthAdapter extends RecyclerView.Adapter<StatisticsMonthAdapter.ViewHolder> {
    private String [] months;
    private int recyclerItemIndex = 0;


    private StatisticsDateAdapter statisticsDateAdapter;
    private StatisticsModel statisticsModel;



    public StatisticsMonthAdapter (String [] monthsList, StatisticsDateAdapter sDA) {
        months = monthsList;
        statisticsDateAdapter = sDA;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //is used to inflate the layout for your list item.
        //TextView view = (TextView)LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
        LayoutInflater inflater  = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.costume_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(row);

        statisticsModel = new StatisticsModel();

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //configures your layouts for the list item (e.g. setting text to a TextView)
        ((ViewHolder)holder).btn.setText(months[position]);

        //Direkt kopiering till statisticsDateAdapter
        holder.btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                recyclerItemIndex = position;
                statisticsModel.setMonthBtn(months[position]);
                statisticsDateAdapter.swapList(statisticsModel.getAllDays());
                notifyDataSetChanged();
            }
        });

        if(recyclerItemIndex==position) {
            holder.btn.setBackgroundColor(Color.LTGRAY);
        } else {
            holder.btn.setBackgroundColor(Color.WHITE);
        }
    }

    @Override
    public int getItemCount() {
        return months.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private Button btn;
        private ViewHolder(View v){
            super(v);
            btn = (Button) itemView.findViewById(R.id.item);
        }

    }
}
