package com.hch.weather_report.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hch.weather_report.R;
import com.hch.weather_report.Utils;
import com.hch.weather_report.model.PredictItem;


import java.util.List;

public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.ViewHolder> {
    private List<PredictItem> predictItemList;
    private Context context;

    public SecondAdapter(List<PredictItem> items, Context context) {
        this.predictItemList= items;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.se_predict_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PredictItem item = predictItemList.get(position);
        holder.se_date.setText(item.getDate());
        holder.se_week.setText("星期"+ Utils.transformDate(item.getWeek()));
        holder.se_temp.setText(item.getDaytemp()+"℃");
        holder.se_wind.setText(item.getDaypower()+"m/s");
    }

    @Override
    public int getItemCount() {
        return predictItemList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView se_date;
        TextView se_week;
        TextView se_temp;
        TextView se_wind;

        public ViewHolder(View view) {
            super(view);
            se_date=view.findViewById(R.id.se_date);
            se_week=view.findViewById(R.id.se_week);
            se_temp=view.findViewById(R.id.se_temp);
            se_wind=view.findViewById(R.id.se_wind);
        }
    }

}
