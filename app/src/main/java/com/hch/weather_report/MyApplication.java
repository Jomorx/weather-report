package com.hch.weather_report;

import android.app.Application;

import androidx.room.Room;

import com.hch.weather_report.database.AppDatabase;


public class MyApplication extends Application {
    private AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "weather-report").fallbackToDestructiveMigration().build();
    }

    public AppDatabase getDatabase() {
        return db;
    }
}
