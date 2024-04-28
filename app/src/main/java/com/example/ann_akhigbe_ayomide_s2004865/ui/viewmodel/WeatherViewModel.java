package com.example.ann_akhigbe_ayomide_s2004865.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ann_akhigbe_ayomide_s2004865.WeatherApplication;
import com.example.ann_akhigbe_ayomide_s2004865.model.data.WeatherData;
import com.example.ann_akhigbe_ayomide_s2004865.model.repository.WeatherRepository;
import com.example.ann_akhigbe_ayomide_s2004865.utilities.Result;


// Name: Anna Akhigbe Ayomide
// StudentId: S2004865
// Programme of Study: Mobile Platform Development
public class WeatherViewModel extends ViewModel {

    private final WeatherRepository repository = WeatherApplication.weatherRepository;
    private final MutableLiveData<Result<WeatherData>> weatherForecastResult = new MutableLiveData<>();
    private final MutableLiveData<Result<WeatherData>> latestWeatherResult = new MutableLiveData<>();

    public LiveData<Result<WeatherData>> getThreeDaysWeatherForecastResult() {
        return weatherForecastResult;
    }

    public LiveData<Result<WeatherData>> getLatestWeatherResult() {
        return latestWeatherResult;
    }

    public void getWeatherForecast(String locationId) {
        repository.getThreeDaysWeatherForecast(locationId, weatherForecastResult::postValue);
    }

    public void getLatestWeatherForecast(String locationId) {
        repository.getLatestWeatherObservation(locationId, latestWeatherResult::postValue);
    }

}
