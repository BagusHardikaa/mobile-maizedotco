package com.example.maizedotco;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // Mengambil ActionBar
        ActionBar actionBar = getSupportActionBar();
        // Memeriksa apakah ActionBar tidak null (untuk menghindari NullPointerException)
        if (actionBar != null) {
            // Menyembunyikan ActionBar
            actionBar.hide();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, Login.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}