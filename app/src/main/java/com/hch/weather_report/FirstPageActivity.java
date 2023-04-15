package com.hch.weather_report;

import static com.hch.weather_report.Utils.BaseUrl;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.hch.weather_report.databinding.ActivityFirstPageBinding;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class FirstPageActivity extends AppCompatActivity {
    private ActivityFirstPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFirstPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        OkHttpClient httpClient = new OkHttpClient();
//        String url = "https://query.asilu.com/weather/gaode?city=成都";


        Request build = new Request.Builder().url(BaseUrl+"?city=成都").get().build();
        httpClient.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                LocalDateTime date = LocalDateTime.now();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                String bodyString = response.body().string();
                System.out.println(bodyString);
                String forecasts = JSONUtil.parseObj(bodyString).get("forecasts").toString();
                String cityConfig = JSONUtil.parseArray(forecasts).get(0).toString();
                JSONObject casts = JSONUtil.parseObj(JSONUtil.parseArray(JSONUtil.parseObj(cityConfig).get("casts")).get(0));
                String temp = StringRound(casts.get("daytemp_float").toString()) + '/' + StringRound(casts.get("nighttemp_float").toString()) + "℃";
                String wind = casts.get("daypower").toString();
                String rain = casts.get("iconn").toString();
                runOnUiThread(() -> {
                    binding.fpDate.setText(date.format(dtf).split(" ")[0]);
                    binding.fpTime.setText(date.format(dtf).split(" ")[1]);
                    binding.fpTem.setText(temp);
                    binding.wind.setText(wind + "m/s");
                    binding.fpRain.setText(rain + "ml");
                });
            }
        });
    }

    private String StringRound(String str) {
        return String.valueOf(Math.round(Double.parseDouble(str)));
    }
}
