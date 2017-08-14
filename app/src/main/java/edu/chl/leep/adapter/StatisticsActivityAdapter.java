package edu.chl.leep.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.linneabark.test.R;

import java.util.List;


/**
 * Created by Evelina on 2017-05-16.
 *
 * A Adapter class which contains some methods to change the view of the activities in fragment_statistics.xml and are being used in StatisticsController
 */

public class StatisticsActivityAdapter extends RecyclerView.Adapter<StatisticsActivityAdapter.ViewHolder>{

    private int recyclerItemIndex = 0;
    private List <String> activity;


    public StatisticsActivityAdapter (List<String> activityList) {
        activity = activityList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater  = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.display_activity,parent,false);
        ViewHolder viewHolder = new ViewHolder(row);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txtActivity.setText(activity.get(position));

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
        if(activity != null) {
            activity.clear();
            activity.addAll(changedList);
        } else {
            activity = changedList;
        }
        notifyDataSetChanged();
    }
}
