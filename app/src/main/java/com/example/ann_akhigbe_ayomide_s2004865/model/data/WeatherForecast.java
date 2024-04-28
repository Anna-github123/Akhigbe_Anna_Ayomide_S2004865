package com.example.ann_akhigbe_ayomide_s2004865.model.data;


// Name: Anna Akhigbe Ayomide
// StudentId: S2004865
// Programme of Study: Mobile Platform Development
public class WeatherForecast {
    private String title;
    private String description;
    private String publishedOn;
    private double latitude;
    private double longitude;


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

    public double getLatitude() {
        return latitude;
    }

    public void setLocationPoints(String locationPoints) {
        String[] points = locationPoints.split(" ");
        latitude = Double.parseDouble(points[0]);
        longitude = Double.parseDouble(points[1]);
    }

    public double getLongitude() {
        return longitude;
    }
}
