package com.hch.weather_report;

import static com.hch.weather_report.Utils.BaseUrl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.hch.weather_report.Adapter.SecondAdapter;
import com.hch.weather_report.databinding.ActivitySecondPageBinding;
import com.hch.weather_report.model.PredictItem;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SecondPageActivity extends AppCompatActivity{
    private ActivitySecondPageBinding binding;
    private ArrayList<PredictItem> predictList = new ArrayList<PredictItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        OkHttpClient httpClient = new OkHttpClient();
//        String url = "https://query.asilu.com/weather/gaode?city=成都";
        Request build = new Request.Builder().url(BaseUrl+"?city=成都").get().build();
        Context that = this;
        httpClient.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    JSONArray predictJsonList =Utils.getPredictCity(response);
                    Gson gson = new Gson();
                    for (int i = 1; i < predictJsonList.length(); i++) {
                        PredictItem predictItem = gson.fromJson(predictJsonList.get(i).toString(), PredictItem.class);
                        predictList.add(predictItem);
                    }
                    runOnUiThread(()->{
                        RecyclerView recyclerView = findViewById(R.id.predictItem);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(that);
                        recyclerView.setLayoutManager(layoutManager);
                        SecondAdapter adapter=new SecondAdapter(predictList,that);
                        recyclerView.setAdapter(adapter);
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
//        binding.secondTextView.setText("这是天气预测页面");
        });
    }

}
