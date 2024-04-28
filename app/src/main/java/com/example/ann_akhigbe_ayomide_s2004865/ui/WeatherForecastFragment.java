package com.example.ann_akhigbe_ayomide_s2004865.ui;

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
        binding.greetingImg.setImageResource(Utilities.getGreetingsImage());
        binding.navIcon.setOnClickListener(view1 -> {
            Intent intent = new Intent(requireActivity(), LatestWeatherObservationActivity.class);
            intent.putExtra(LOCATION_ID, locationId);
            intent.putExtra(LATITUDE, currentItem.getThreeDaysForecast().get(0).getLatitude());
            intent.putExtra(LONGITUDE, currentItem.getThreeDaysForecast().get(0).getLongitude());
            startActivity(intent);
        });
        WeatherViewModel viewModel = new ViewModelProvider(requireActivity()).get(WeatherViewModel.class);
        viewModel.getWeatherForecast(locationId);
        viewModel.getThreeDaysWeatherForecastResult().observe(getViewLifecycleOwner(), weatherDataResult -> {
            binding.progress.setVisibility(View.GONE);
            if (weatherDataResult instanceof Result.Success) {
                currentItem = ((Result.Success<WeatherData>) weatherDataResult).data;
                binding.title.setText(currentItem.getTitle());
                binding.description.setText(currentItem.getDescription());
                display3DaysForecast(currentItem.getThreeDaysForecast());
                binding.navIcon.setVisibility(View.VISIBLE);
            } else {
                binding.navIcon.setVisibility(View.GONE);
            }
        });
    }

    private void display3DaysForecast(List<WeatherForecast> forecasts) {
        binding.titleDay0.setText(forecasts.get(0).getTitle());
        binding.descriptionDay0.setText(forecasts.get(0).getDescription());

        binding.day1Forecast.setCardBackgroundColor(getResources().getColor(R.color.secondaryDarkColor));
        binding.titleDay1.setText(forecasts.get(1).getTitle());
        binding.descriptionDay1.setText(forecasts.get(1).getDescription());

        binding.day2Forecast.setCardBackgroundColor(getResources().getColor(R.color.black_light));
        binding.titleDay2.setText(forecasts.get(2).getTitle());
        binding.descriptionDay2.setText(forecasts.get(2).getDescription());
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
}