package edu.chl.leep.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.linneabark.test.R;

import java.util.ArrayList;
import java.util.List;

import edu.chl.leep.ctrl.StatisticsController;
import edu.chl.leep.service.StatisticsDisplayService;
import edu.chl.leep.service.StatisticsService;

/**
 * Created by Evelina on 2017-05-12.
 *
 * A Adapter class which contains some methods to change the view of dates in fragment_statistics.xml and are being used in StatisticsController
 */

public class StatisticsDateAdapter extends RecyclerView.Adapter<StatisticsDateAdapter.ViewHolder>{

    private int recyclerItemIndex = 0;
    private List<Integer> date;

    private StatisticsActivityAdapter statisticsActivityAdapter;
    private StatisticsController statisticsController;
    private StatisticsService statisticsService;
    private StatisticsDisplayService statisticsDisplayService;

    public StatisticsDateAdapter (List<Integer> dateList, StatisticsActivityAdapter sAA, StatisticsDisplayService sDS, StatisticsController sC, StatisticsService sS) {
        date = dateList;
        statisticsActivityAdapter = sAA;
        statisticsDisplayService = sDS;
        statisticsController = sC;
        statisticsService = sS;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater  = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.costume_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(row);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.btn.setText(String.valueOf(date.get(position)));
        holder.btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                recyclerItemIndex = position;
                statisticsController.setDateBtn(String.valueOf(date.get(position)));
                statisticsActivityAdapter.swapList(statisticsService.getActivitysToDisplay(statisticsDisplayService, statisticsController));
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

    public void swapList (List<Integer> changedList) {
        if(date != null) {
            date.clear();
            date.addAll(changedList);
        } else {
            date = changedList;
        }
        notifyDataSetChanged();
    }
}
