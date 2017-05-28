package com.example.linneabark.test;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import edu.chl.leep.model.StatisticsModel;

/**
 * Created by Evelina on 2017-05-12.
 *
 * A Adapter class which contains some methods to change the view of dates in fragment_statistics.xml and are being used in StatisticsController
 */

public class StatisticsDateAdapter extends RecyclerView.Adapter<StatisticsDateAdapter.ViewHolder>{

    private int recyclerItemIndex = 0;
    private List<String> date;

    private StatisticsActivityAdapter statisticsActivityAdapter;
    private StatisticsModel statisticsModel;



    public StatisticsDateAdapter (List<String> dateList, StatisticsActivityAdapter sAA) {
        date = dateList;
        statisticsActivityAdapter = sAA;
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
        holder.btn.setText(date.get(position));
        holder.btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                recyclerItemIndex = position;
                statisticsModel.setDateBtn(date.get(position));
                statisticsActivityAdapter.swapList(statisticsModel.getAllActivitys(statisticsActivityAdapter));
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
        return date.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private Button btn;
        private ViewHolder(View v){
            super(v);
            btn = (Button) itemView.findViewById(R.id.item);
        }
    }

    public void swapList (List<String> changedList) {
        System.out.println("klass statisticsDateAdapter, metod swapList. Kommer jag hit?");
        System.out.println("vad är date just nu? size är --> " +  date.size());
        if(date != null) {
            System.out.println("kommer jag in i if?");
            date.clear();
            System.out.println("is the clear metod removing? date.size() --> " + date.size());
            date.addAll(changedList);
            System.out.println("date size after if --> " + date.size());
        } else {
            System.out.println("Eller komme rjag in i else?");
            date = changedList;
        }

        System.out.println("date listan innehåller: " + date.toString());
        notifyDataSetChanged();
    }
}
