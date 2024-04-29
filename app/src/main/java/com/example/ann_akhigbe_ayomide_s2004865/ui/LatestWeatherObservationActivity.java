package com.example.ann_akhigbe_ayomide_s2004865.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.ann_akhigbe_ayomide_s2004865.R;
import com.example.ann_akhigbe_ayomide_s2004865.model.data.WeatherData;
import com.example.ann_akhigbe_ayomide_s2004865.databinding.ActivityLatestWeatherObservationBinding;
import com.example.ann_akhigbe_ayomide_s2004865.ui.viewmodel.WeatherViewModel;
import com.example.ann_akhigbe_ayomide_s2004865.utilities.Result;
import com.example.ann_akhigbe_ayomide_s2004865.utilities.Utilities;


// Name: Anna Akhigbe Ayomide
// StudentId: S2004865
// Programme of Study: Mobile Platform Development
public class LatestWeatherObservationActivity extends AppCompatActivity {

    private ActivityLatestWeatherObservationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(Utilities.getApplicationTheme());
        binding = ActivityLatestWeatherObservationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.greetingImg.setImageResource(Utilities.getGreetingsImage());
        binding.rootLayout.setBackgroundColor(Utilities.getMainViewColor());

        String locationId = getIntent().getStringExtra(WeatherForecastFragment.LOCATION_ID);
        double latitude = getIntent().getDoubleExtra(WeatherForecastFragment.LATITUDE, 0.0);
        double longitude = getIntent().getDoubleExtra(WeatherForecastFragment.LONGITUDE, 0.0);
        String location = getIntent().getStringExtra(WeatherForecastFragment.LOCATION);

        WeatherViewModel viewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
        viewModel.getLatestWeatherForecast(locationId);
        viewModel.getLatestWeatherResult().observe(this, weatherDataResult -> {
            binding.progress.setVisibility(View.GONE);
            if (weatherDataResult instanceof Result.Success) {
                WeatherData weatherData = ((Result.Success<WeatherData>) weatherDataResult).data;
                binding.title.setText(weatherData.getTitle());
                Log.d("God", weatherData.getTitle());
                binding.title.setText(getString(R.string.location, weatherData.getTitle(), location));
                binding.description.setText(weatherData.getDescription());
                binding.publishedOn.setText(String.format("Published On: %s", weatherData.getPublishedOn()));
                binding.titleDay0.setText(weatherData.getThreeDaysForecast().get(0).getTitle());
                binding.descriptionDay0.setText(weatherData.getThreeDaysForecast().get(0).getDescription());
                binding.latitude.setText(String.format("Latitude: %s", latitude));
                binding.longitude.setText(String.format("Longitude: %s", longitude));
            }
        });
    }
}