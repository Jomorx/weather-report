package com.hch.weather_report.database.pojo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "city")
public class City {
    @PrimaryKey(autoGenerate = true)
    private int uid;
    @ColumnInfo(name = "city_name")
    private String cityName;

    @Override
    public String toString() {
        return "City{" +
                "uid=" + uid +
                ", cityName='" + cityName + '\'' +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public City(String cityName) {
        this.cityName = cityName;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
