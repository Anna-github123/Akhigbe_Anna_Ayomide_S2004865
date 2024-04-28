package com.example.ann_akhigbe_ayomide_s2004865.model.repository;

import com.example.ann_akhigbe_ayomide_s2004865.model.cache.WeatherCache;
import com.example.ann_akhigbe_ayomide_s2004865.model.data.WeatherData;
import com.example.ann_akhigbe_ayomide_s2004865.utilities.Result;
import com.example.ann_akhigbe_ayomide_s2004865.utilities.ResultCallback;
import com.example.ann_akhigbe_ayomide_s2004865.utilities.WeatherInfoParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


// Name: Anna Akhigbe Ayomide
// StudentId: S2004865
// Programme of Study: Mobile Platform Development
public class WeatherRepository {

    private static final String THREE_DAYS_URL = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/";
    private static final String LATEST_OBSERVATION_URL = "https://weather-broker-cdn.api.bbci.co.uk/en/observation/rss/";

    private final WeatherCache weatherCache;

    public WeatherRepository(WeatherCache weatherCache) {
        this.weatherCache = weatherCache;
    }

    private final Executor executor = Executors.newFixedThreadPool(4);

    private void getThreeDaysWeatherData(String locationId, ResultCallback<WeatherData> callback) {
        executor.execute(() -> {
            Result<WeatherData> result = executeHttpRequest(THREE_DAYS_URL + locationId);
            if (result instanceof Result.Success) {
                weatherCache.saveThreeDaysWeatherData(locationId, ((Result.Success<WeatherData>) result).data);
            }
            callback.onComplete(result);
        });
    }

    public void getThreeDaysWeatherForecast(String locationId, ResultCallback<WeatherData> callback) {
        WeatherData cachedWeatherData = weatherCache.get3DaysWeatherForecastById(locationId);
        if (cachedWeatherData != null) {
            callback.onComplete(new Result.Success<>(cachedWeatherData));
        } else {
            getThreeDaysWeatherData(locationId, callback);
        }
    }

    private void getLatestWeatherObservationData(String locationId, ResultCallback<WeatherData> callback) {
        executor.execute(() -> {
            Result<WeatherData> result = executeHttpRequest(LATEST_OBSERVATION_URL + locationId);
            if (result instanceof Result.Success) {
                weatherCache.saveLatestWeatherData(locationId, ((Result.Success<WeatherData>) result).data);
            }
            callback.onComplete(result);
        });
    }

    public void getLatestWeatherObservation(String locationId, ResultCallback<WeatherData> callback) {
        WeatherData cachedWeatherData = weatherCache.getLatestWeatherDataById(locationId);
        if (cachedWeatherData != null) {
            callback.onComplete(new Result.Success<>(cachedWeatherData));
        } else {
            getLatestWeatherObservationData(locationId, callback);
        }
    }

    public void populateCache() {
        String[] locationId = {"2648579", "2643743", "5128581", "287286", "934154", "1185241"};

        for (String id : locationId) {
            getLatestWeatherObservationData(id, result -> {
                if (result instanceof Result.Success) {
                    weatherCache.saveLatestWeatherData(id, ((Result.Success<WeatherData>) result).data);
                }
            });

            getThreeDaysWeatherData(id, result -> {
                if (result instanceof Result.Success) {
                    weatherCache.saveThreeDaysWeatherData(id, ((Result.Success<WeatherData>) result).data);
                }
            });
        }
    }

    private Result<WeatherData> executeHttpRequest(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            WeatherData weatherData = WeatherInfoParser.parseWeatherData(httpURLConnection.getInputStream());
            httpURLConnection.disconnect();
            return new Result.Success<>(weatherData);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result.Error<>(e);
        }
    }
}
