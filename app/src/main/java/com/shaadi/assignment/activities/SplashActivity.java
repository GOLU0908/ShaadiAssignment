package com.shaadi.assignment.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.shaadi.assignment.R;
import com.shaadi.assignment.utilities.EndPointAPI;


public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new CountDownTimer(EndPointAPI.MILISEC, EndPointAPI.INTERVAL) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }.start();

    }
}
