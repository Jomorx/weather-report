package com.hch.weather_report.model;

public class PredictItem {
    private String date;
    private String week;
    private String dayweather;
    private String nightweather;
    private String daytemp;
    private String nighttemp;
    private String daywind;
    private String nightwind;
    private String daypower;
    private String nightpower;
    private String daytemp_float;
    private String nighttemp_float;
    private String icond;
    private String iconn;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDayweather() {
        return dayweather;
    }

    public void setDayweather(String dayweather) {
        this.dayweather = dayweather;
    }

    public String getNightweather() {
        return nightweather;
    }

    public void setNightweather(String nightweather) {
        this.nightweather = nightweather;
    }

    public String getDaytemp() {
        return daytemp;
    }

    public void setDaytemp(String daytemp) {
        this.daytemp = daytemp;
    }

    public String getNighttemp() {
        return nighttemp;
    }

    public void setNighttemp(String nighttemp) {
        this.nighttemp = nighttemp;
    }

    public String getDaywind() {
        return daywind;
    }

    public void setDaywind(String daywind) {
        this.daywind = daywind;
    }

    public String getNightwind() {
        return nightwind;
    }

    public void setNightwind(String nightwind) {
        this.nightwind = nightwind;
    }

    public String getDaypower() {
        return daypower;
    }

    public void setDaypower(String daypower) {
        this.daypower = daypower;
    }

    public String getNightpower() {
        return nightpower;
    }

    public void setNightpower(String nightpower) {
        this.nightpower = nightpower;
    }

    public String getDaytemp_float() {
        return daytemp_float;
    }

    public void setDaytemp_float(String daytemp_float) {
        this.daytemp_float = daytemp_float;
    }

    public String getNighttemp_float() {
        return nighttemp_float;
    }

    public void setNighttemp_float(String nighttemp_float) {
        this.nighttemp_float = nighttemp_float;
    }

    public String getIcond() {
        return icond;
    }

    public void setIcond(String icond) {
        this.icond = icond;
    }

    public String getIconn() {
        return iconn;
    }

    public void setIconn(String iconn) {
        this.iconn = iconn;
    }

    @Override
    public String toString() {
        return "PredictItem{" +
                "date='" + date + '\'' +
                ", week='" + week + '\'' +
                ", dayweather='" + dayweather + '\'' +
                ", nightweather='" + nightweather + '\'' +
                ", daytemp='" + daytemp + '\'' +
                ", nighttemp='" + nighttemp + '\'' +
                ", daywind='" + daywind + '\'' +
                ", nightwind='" + nightwind + '\'' +
                ", daypower='" + daypower + '\'' +
                ", nightpower='" + nightpower + '\'' +
                ", daytemp_float='" + daytemp_float + '\'' +
                ", nighttemp_float='" + nighttemp_float + '\'' +
                ", icond='" + icond + '\'' +
                ", iconn='" + iconn + '\'' +
                '}';
    }
}
