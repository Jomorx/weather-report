package com.hch.weather_report;


import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Response;

public class Utils {
    static final String BaseUrl = "http://192.168.88.1:3000/weather";
    static public String transformDate (String str){
        Map<String, String> map = new HashMap<String,String>();
        map.put("1","一");
        map.put("2","二");
        map.put("3","三");
        map.put("4","四");
        map.put("5","五");
        map.put("6","六");
        map.put("7","七");
    return map.get(str);
    }
    static public JSONArray getPredictCity(Response response) throws  Exception{
        String bodyString = response.body().string();
        JSONTokener tokener = new JSONTokener(bodyString);
        JSONObject json = (JSONObject) tokener.nextValue();
        JSONArray forecasts = json.getJSONArray("forecasts");
        return forecasts.getJSONObject(0).getJSONArray("casts");
    }
}
