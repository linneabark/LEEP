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
 *
 * A Adapter class which contains some methods to change the month view in fragment_statistics.xml and are being used in StatisticsController
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
        LayoutInflater inflater  = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.costume_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(row);
        statisticsModel = new StatisticsModel();

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.btn.setText(months[position]);
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
