package com.example.ann_akhigbe_ayomide_s2004865.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.ann_akhigbe_ayomide_s2004865.ui.WeatherForecastFragment;


// Name: Anna Akhigbe Ayomide
// StudentId: S2004865
// Programme of Study: Mobile Platform Development
public class WeatherPagerAdapter extends FragmentStateAdapter {

    private final String[] locationId = {"2648579", "2643743", "5128581", "287286", "934154", "1185241"};

    public WeatherPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int realPosition = position % locationId.length;
        return WeatherForecastFragment.newInstance(locationId[realPosition]);
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }
}
