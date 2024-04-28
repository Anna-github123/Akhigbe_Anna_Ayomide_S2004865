package com.example.ann_akhigbe_ayomide_s2004865.model.data;

import java.util.List;


// Name: Anna Akhigbe Ayomide
// StudentId: S2004865
// Programme of Study: Mobile Platform Development
public class WeatherData {
    private String title;
    private String description;
    private String publishedOn;
    private List<WeatherForecast> threeDaysForecast;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }

    public List<WeatherForecast> getThreeDaysForecast() {
        return threeDaysForecast;
    }

    public void setThreeDaysForecast(List<WeatherForecast> threeDaysForecast) {
        this.threeDaysForecast = threeDaysForecast;
    }

//    @NonNull
//    @Override
//    public String toString() {
//        return title + " " + description + " " + publishedOn + " threeDaysForecast is " + threeDaysForecast.size();
//    }
}
