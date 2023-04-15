package com.hch.weather_report;

import static com.hch.weather_report.Utils.BaseUrl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.hch.weather_report.database.AppDatabase;
import com.hch.weather_report.database.pojo.City;
import com.hch.weather_report.databinding.ActivitySearchPageBinding;
import com.hch.weather_report.model.PredictItem;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class SearchActivity extends AppCompatActivity {
    private ActivitySearchPageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String cityName = getIntent().getStringExtra("searchText");
        MyApplication app = (MyApplication) this.getApplication();
        AppDatabase db = app.getDatabase();
        OkHttpClient httpClient = new OkHttpClient();
        Request build = new Request.Builder().url(BaseUrl+"?city="+cityName).get().build();
        httpClient.newCall(build).enqueue(new Callback(){
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                try {

                    PredictItem predictItem = new Gson().fromJson(Utils.getPredictCity(response).get(0).toString(), PredictItem.class);
                    runOnUiThread(()->{
                        binding.aspCity.setText(cityName);
                        binding.aspDate.setText(predictItem.getDate());
                        binding.aspTemp.setText(predictItem.getDaytemp());
                        binding.aspWeather.setText(predictItem.getDayweather());

                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
            }
        });


        findViewById(R.id.asp_return_btn).setOnClickListener((View view)->{
//            Intent intent = new Intent(SearchActivity.this, ThirdPageActivity.class);
//            startActivity(intent);
            new Thread(()->{
                db.cityMapper().deleteAllCity();
                runOnUiThread(()->{
                    onBackPressed();
                });
            }).start();

        });
        findViewById(R.id.asp_add_btn).setOnClickListener((View view)->{
            new Thread(()->{
                db.cityMapper().insertCity(new City(cityName));
//                Intent intent = new Intent(SearchActivity.this, ThirdPageActivity.class);
//                startActivity(intent);
                runOnUiThread(()->{
                    onBackPressed();
                });
            }).start();

        });
        System.out.println();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        getWindow().getDecorView().getRootView().invalidate();
    }
}
