package com.example.ann_akhigbe_ayomide_s2004865.model.cache;

import com.example.ann_akhigbe_ayomide_s2004865.model.data.WeatherData;

import java.util.HashMap;


// Name: Anna Akhigbe Ayomide
// StudentId: S2004865
// Programme of Study: Mobile Platform Development
public class WeatherCache {

    private final HashMap<String, WeatherData> threeDaysForecastCache = new HashMap<>();
    private final HashMap<String, WeatherData> latestWeatherCache = new HashMap<>();

    public void saveThreeDaysWeatherData(String locationId, WeatherData weatherData) {
        threeDaysForecastCache.put(locationId, weatherData);
    }

    public void saveLatestWeatherData(String locationId, WeatherData weatherData) {
        latestWeatherCache.put(locationId, weatherData);
    }

    public WeatherData get3DaysWeatherForecastById(String locationId) {
        return threeDaysForecastCache.get(locationId);
    }

    public WeatherData getLatestWeatherDataById(String locationId) {
        return latestWeatherCache.get(locationId);
    }

}
