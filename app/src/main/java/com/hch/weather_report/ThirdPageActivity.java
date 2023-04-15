package com.hch.weather_report;

import android.app.appsearch.SearchResult;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.hch.weather_report.Adapter.SecondAdapter;
import com.hch.weather_report.Adapter.TpPredictCityAdapter;
import com.hch.weather_report.database.AppDatabase;
import com.hch.weather_report.database.pojo.City;
import com.hch.weather_report.databinding.ActivityThirdPageBinding;
import com.hch.weather_report.model.PredictItem;

import org.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ThirdPageActivity extends AppCompatActivity {
    private ActivityThirdPageBinding binding;


    @Override
    protected void onResume() {
        super.onResume();
        Map<String, PredictItem> cityPredictMap = new Hashtable();
        EditText searchText = findViewById(R.id.sp_search_text);
        Button searchButton = findViewById(R.id.sp_search_button);
        MyApplication app = (MyApplication) this.getApplication();
        AppDatabase db = app.getDatabase();

        searchButton.setOnClickListener((View view) -> {

            new Thread(() -> {
                String CityName = searchText.getText().toString();
                Intent intent = new Intent(ThirdPageActivity.this, SearchActivity.class);
                intent.putExtra("searchText", CityName);
                startActivity(intent);
            }).start();


        });
        new Thread(() -> {
            List<City> cityList = db.cityMapper().getAll();
            OkHttpClient client = new OkHttpClient();
            CountDownLatch countDownLatch = new CountDownLatch(cityList.size());
            for (int i = 0; i < cityList.size(); i++) {
                String url = Utils.BaseUrl+"?city=" + cityList.get(i).getCityName();
                Request build = new Request.Builder().url(url).get().build();
                int finalI = i;
                client.newCall(build).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) {
                        try {
                            JSONArray predictCity = Utils.getPredictCity(response);
                            System.out.println(cityList);
                            cityPredictMap.put(cityList.get(finalI).getCityName(), new Gson().fromJson(predictCity.get(0).toString(), PredictItem.class));
                            countDownLatch.countDown();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            try {
                countDownLatch.await();
                runOnUiThread(() -> {
                    RecyclerView recyclerView = findViewById(R.id.predictCity);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
                    recyclerView.setLayoutManager(layoutManager);
                    TpPredictCityAdapter adapter = new TpPredictCityAdapter(cityPredictMap, cityList, this);
                    recyclerView.setAdapter(adapter);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThirdPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}
