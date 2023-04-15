package com.hch.weather_report.database.mapper;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.hch.weather_report.database.pojo.City;

import java.util.List;

@Dao
public interface CityMapper {
    @Query("SELECT * FROM city")
    List<City> getAll();
    @Insert
    void insertCity(City city);

    @Query("DELETE FROM city")
    void deleteAllCity();
}
