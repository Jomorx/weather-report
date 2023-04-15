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
import com.hch.weather_report.database.pojo.City;
import com.hch.weather_report.model.PredictItem;


import java.util.List;
import java.util.Map;

public class TpPredictCityAdapter extends RecyclerView.Adapter<TpPredictCityAdapter.ViewHolder> {
    private Map<String,PredictItem> cityPredictMap;
    private Context context;
    private List<City> cityList;
    public TpPredictCityAdapter(Map<String,PredictItem> cityPredictMap, List<City> cityList, Context context) {
        this.cityPredictMap= cityPredictMap;
        this.cityList=cityList;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tp_city_predict, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String cityName= cityList.get(position).getCityName();
//        System.out.println(cityPredictMap);
        PredictItem item = cityPredictMap.get(cityName);
        System.out.println("cityName---"+cityName);
        System.out.println("item---"+item);
        System.out.println("item.getDate()---"+item.getDate());

        holder.tcp_date.setText(item.getDate());
        holder.tcp_city_name.setText(cityName);
        holder.tcp_temp.setText(item.getDaytemp()+"℃");
        holder.tcp_wind.setText(item.getDaypower()+"m/s");
    }

    @Override
    public int getItemCount() {
        return cityPredictMap.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tcp_city_name;
        TextView tcp_date;
        TextView tcp_temp;
        TextView tcp_wind;

        public ViewHolder(View view) {
            super(view);
            tcp_city_name=view.findViewById(R.id.tcp_city_name);
            tcp_date=view.findViewById(R.id.tcp_date);
            tcp_temp=view.findViewById(R.id.tcp_temp);
            tcp_wind=view.findViewById(R.id.tcp_wind);
        }
    }

}
