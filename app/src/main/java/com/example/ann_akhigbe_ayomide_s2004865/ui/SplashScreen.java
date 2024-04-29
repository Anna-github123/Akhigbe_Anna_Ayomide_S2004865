package com.example.ann_akhigbe_ayomide_s2004865.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.ann_akhigbe_ayomide_s2004865.R;
import com.example.ann_akhigbe_ayomide_s2004865.databinding.ActivitySplashScreenBinding;


// Name: Anna Akhigbe Ayomide
// StudentId: S2004865
// Programme of Study: Mobile Platform Development
public class SplashScreen extends AppCompatActivity {
    private ActivitySplashScreenBinding binding;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupDisplayAnimation();
        activateDelayForAnimation();
    }

    private void activateDelayForAnimation() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                SplashScreen.this.finish();
            }
        }, 3000);


    }

    void setupDisplayAnimation() {
        Animation topAnimation = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.upward_animation);
        Animation bottomAnimation = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.bottom_animation);
        binding.logo.setAnimation(topAnimation);
        binding.weather.setAnimation(bottomAnimation);
    }
}