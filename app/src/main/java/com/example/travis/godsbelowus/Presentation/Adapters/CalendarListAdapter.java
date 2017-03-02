package com.example.travis.godsbelowus.Presentation.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.travis.godsbelowus.Presentation.Models.Dates;
import com.example.travis.godsbelowus.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by travis on 3/1/17.
 */

public class CalendarListAdapter extends RecyclerView.Adapter<CalendarListAdapter.DatesViewHolder> {

    private ArrayList<Dates> list;

    public CalendarListAdapter(ArrayList<Dates> list) {
        this.list = list;
    }

    @Override
    public DatesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_calendar_row, parent, false);
        return new DatesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DatesViewHolder holder, int position) {
        holder.date.setText(list.get(position).getDate());
        holder.time.setText(list.get(position).getTime());
        holder.location.setText(list.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DatesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_view_date)
        private TextView date;

        @BindView(R.id.text_view_time)
        private TextView time;

        @BindView(R.id.text_view_location)
        private TextView location;

        public DatesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
