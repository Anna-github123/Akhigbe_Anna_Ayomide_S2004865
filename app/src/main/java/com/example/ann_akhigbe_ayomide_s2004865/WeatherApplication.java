package com.example.ann_akhigbe_ayomide_s2004865;

import android.app.Application;

import com.example.ann_akhigbe_ayomide_s2004865.model.cache.WeatherCache;
import com.example.ann_akhigbe_ayomide_s2004865.model.repository.WeatherRepository;

// Name: Anna Akhigbe Ayomide
// StudentId: S2004865
// Programme of Study: Mobile Platform Development
public class WeatherApplication extends Application {

    private static final WeatherCache cache = new WeatherCache();
    public static final WeatherRepository weatherRepository = new WeatherRepository(cache);

    @Override
    public void onCreate() {
        super.onCreate();
        weatherRepository.populateCache();
    }
}
