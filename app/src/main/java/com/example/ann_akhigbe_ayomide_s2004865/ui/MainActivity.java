package com.example.ann_akhigbe_ayomide_s2004865.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ann_akhigbe_ayomide_s2004865.databinding.ActivityMainBinding;
import com.example.ann_akhigbe_ayomide_s2004865.ui.adapter.WeatherPagerAdapter;
import com.example.ann_akhigbe_ayomide_s2004865.utilities.Utilities;


// Name: Anna Akhigbe Ayomide
// StudentId: S2004865
// Programme of Study: Mobile Platform Development
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private WeatherPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(Utilities.getApplicationTheme());
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new WeatherPagerAdapter(this);
        binding.viewPager.setAdapter(adapter);
        binding.viewPager.setCurrentItem(0, false);
    }
}