package com.hch.weather_report.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.hch.weather_report.database.mapper.CityMapper;
import com.hch.weather_report.database.pojo.City;

@Database(entities = {City.class},version = 6,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CityMapper cityMapper();
}