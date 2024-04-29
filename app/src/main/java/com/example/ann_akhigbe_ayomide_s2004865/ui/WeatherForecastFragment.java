package com.example.ann_akhigbe_ayomide_s2004865.ui;

import static com.example.ann_akhigbe_ayomide_s2004865.utilities.Utilities.getBackGroundImage;
import static com.example.ann_akhigbe_ayomide_s2004865.utilities.Utilities.getCurrentDate;
import static com.example.ann_akhigbe_ayomide_s2004865.utilities.Utilities.getTempsImage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.ann_akhigbe_ayomide_s2004865.R;
import com.example.ann_akhigbe_ayomide_s2004865.databinding.FragmentWeatherForecastBinding;
import com.example.ann_akhigbe_ayomide_s2004865.model.data.WeatherData;
import com.example.ann_akhigbe_ayomide_s2004865.model.data.WeatherDataDto;
import com.example.ann_akhigbe_ayomide_s2004865.model.data.WeatherForecast;
import com.example.ann_akhigbe_ayomide_s2004865.model.data.WeatherInfo;
import com.example.ann_akhigbe_ayomide_s2004865.ui.viewmodel.WeatherViewModel;
import com.example.ann_akhigbe_ayomide_s2004865.utilities.Result;
import com.example.ann_akhigbe_ayomide_s2004865.utilities.Utilities;

import java.util.List;


// Name: Anna Akhigbe Ayomide
// StudentId: S2004865
// Programme of Study: Mobile Platform Development
public class WeatherForecastFragment extends Fragment {

    private static final String ARG_PARAM = "param";
    public static final String LOCATION_ID = "locationId";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";

    public static final String LOCATION = "location";

    private WeatherData currentItem;
    private String locationId = "";

    private FragmentWeatherForecastBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentWeatherForecastBinding.inflate(inflater, container, false);
        locationId = getArguments().getString(ARG_PARAM, "");
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.navIcon.setOnClickListener(view1 -> {
            Intent intent = new Intent(requireActivity(), LatestWeatherObservationActivity.class);
            intent.putExtra(LOCATION_ID, locationId);
            intent.putExtra(LATITUDE, currentItem.getThreeDaysForecast().get(0).getLatitude());
            intent.putExtra(LONGITUDE, currentItem.getThreeDaysForecast().get(0).getLongitude());
            intent.putExtra(LOCATION, getLastTwoStrings(currentItem.getTitle()));
            startActivity(intent);
        });
        WeatherViewModel viewModel = new ViewModelProvider(requireActivity()).get(WeatherViewModel.class);
        viewModel.getWeatherForecast(locationId);
        viewModel.getThreeDaysWeatherForecastResult().observe(getViewLifecycleOwner(), weatherDataResult -> {
            binding.progress.setVisibility(View.GONE);
            binding.day0Forecast.setVisibility(View.VISIBLE);
            if (weatherDataResult instanceof Result.Success) {
                currentItem = ((Result.Success<WeatherData>) weatherDataResult).data;
                binding.plainHeader.location.setText(getLastTwoStrings(currentItem.getTitle()));
                binding.plainHeader.date.setText(getCurrentDate());
                binding.rootLayout.setBackground(getResources().getDrawable(getBackGroundImage(getLastTwoStrings(currentItem.getTitle()))));
                display3DaysForecast(currentItem.getThreeDaysForecast());
                binding.navIcon.setVisibility(View.VISIBLE);
            } else {
                binding.navIcon.setVisibility(View.GONE);
            }
        });
    }

    private void display3DaysForecast(List<WeatherForecast> forecasts) {

        WeatherInfo weatherInfo = new WeatherInfo(forecasts.get(0).getTitle());
        WeatherDataDto weatherData = new WeatherDataDto(forecasts.get(0).getDescription());

        assert binding.plainView != null;
        binding.plainView.cloudCondition.setText(weatherInfo.getWeatherCondition());
        binding.plainView.weatherDay.setText(weatherInfo.getDay());
        binding.plainView.cloudHumidity.setText(getString(R.string.humidity_20,weatherData.getHumidity()));
        binding.plainView.minTemp.setText(getString(R.string.min_temp, weatherInfo.getMinTemperature()));
        binding.plainView.cloudImg.setImageResource(getTempsImage(weatherInfo.getWeatherCondition()));
        binding.plainView.rangeTemp.setText(getString(R.string.min_max, weatherInfo.getMinTemperature(), weatherInfo.getMaxTemperature()));

        // 2nd
        WeatherInfo weatherInfo1 = new WeatherInfo(forecasts.get(1).getTitle());
        WeatherDataDto weatherData1 = new WeatherDataDto(forecasts.get(1).getDescription());

        assert binding.plainView1 != null;
        binding.plainView1.parentLayout.setBackgroundColor(getResources().getColor(R.color.blue));
        binding.plainView1.cloudCondition.setText(weatherInfo1.getWeatherCondition());
        binding.plainView1.weatherDay.setText(weatherInfo1.getDay());
        binding.plainView1.cloudImg.setImageResource(getTempsImage(weatherInfo1.getWeatherCondition()));
        binding.plainView1.cloudHumidity.setText(getString(R.string.humidity_20,weatherData1.getHumidity()));
        binding.plainView1.minTemp.setText(getString(R.string.min_temp, weatherInfo1.getMinTemperature()));
        binding.plainView1.rangeTemp.setText(getString(R.string.min_max, weatherInfo1.getMinTemperature(), weatherInfo1.getMaxTemperature()));

        // 3rd
        WeatherInfo weatherInfo2 = new WeatherInfo(forecasts.get(2).getTitle());
        WeatherDataDto weatherData2 = new WeatherDataDto(forecasts.get(2).getDescription());

        assert binding.plainView2 != null;
        binding.plainView2.parentLayout.setBackgroundColor(getResources().getColor(R.color.blue_dark));
        binding.plainView2.cloudCondition.setText(weatherInfo2.getWeatherCondition());
        binding.plainView2.weatherDay.setText(weatherInfo2.getDay());
        binding.plainView2.cloudImg.setImageResource(getTempsImage(weatherInfo2.getWeatherCondition()));
        binding.plainView2.cloudHumidity.setText(getString(R.string.humidity_20,weatherData2.getHumidity()));
        binding.plainView2.minTemp.setText(getString(R.string.min_temp, weatherInfo2.getMinTemperature()));
        binding.plainView2.rangeTemp.setText(getString(R.string.min_max, weatherInfo2.getMinTemperature(), weatherInfo2.getMaxTemperature()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public static WeatherForecastFragment newInstance(String param) {
        WeatherForecastFragment fragment = new WeatherForecastFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM, param);
        fragment.setArguments(bundle);
        return fragment;
    }
    public static String getLastTwoStrings(String inputString) {
        // Split the input string by spaces
        String[] words = inputString.split(" ");

        // Iterate through the words in reverse order
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            // If the current word is "For", stop iterating
            if (words[i].equals("for")) {
                break;
            }
            // Otherwise, append the word and a space to the result
            reversed.insert(0, words[i] + " ");
        }

        // Remove the trailing space and return the reversed string
        return reversed.toString().trim();
    }
}