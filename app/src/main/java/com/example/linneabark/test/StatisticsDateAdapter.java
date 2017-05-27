package com.example.linneabark.test;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.chl.leep.ctrl.Statistics;
import edu.chl.leep.model.ActivityRow;
import edu.chl.leep.model.StatisticsModel;
import edu.chl.leep.utils.FindWhichMonth;

/**
 * Created by Evelina on 2017-05-12.
 */

public class StatisticsDateAdapter extends RecyclerView.Adapter<StatisticsDateAdapter.ViewHolder>{

    private int recyclerItemIndex = 0;
    Context context;
    private List<String> date;

    StatisticsActivityAdapter statisticsActivityAdapter;
    StatisticsModel statisticsModel = new StatisticsModel();



    public StatisticsDateAdapter (Context context, List<String> dateList, StatisticsActivityAdapter sAA) {
        this.context = context;
        date = dateList;
        statisticsActivityAdapter = sAA;
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

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //configures your layouts for the list item (e.g. setting text to a TextView)
        //holder.mTextView.setText(months[position]);
        //((ViewHolder)holder).btn.setText(date[position]);
        ((ViewHolder)holder).btn.setText(date.get(position));

        //Direkt kopiering av StatisticsMonthAdapter
        holder.btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                recyclerItemIndex = position;
                statisticsModel.setDateBtn(date.get(position));
                statisticsActivityAdapter.swapList(StatisticsModel.getAllActivitys(statisticsActivityAdapter));
                notifyDataSetChanged();
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
        return date.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button btn;
        public ViewHolder(View v){
            super(v);
            btn = (Button) itemView.findViewById(R.id.item);
        }

    }
    //private int dateOfBtn;
    //public String getDateOfBtn () {
   //     return date.get(dateOfBtn);
   // }

    public void swapList (List<String> changedList) {
        System.out.println("klass statisticsDateAdapter, metod swapList. Kommer jag hit?");
        System.out.println("vad är date just nu? size är --> " +  date.size());
        if(date != null) {
            System.out.println("kommer jag in i if?");
            date.clear();
            /*for (int i =0; i < date.size(); i++){
                date.remove(i);
                System.out.println("is the remove metod removing? date.size() --> " + date.size());
            }*/
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
