package com.example.maizedotco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class JagungmanisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jagungmanis);

        BottomNavigationView nav = findViewById(R.id.bottomnavview);

        nav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home1: {
                    Intent intent = new Intent(this, Home.class);
                    startActivity(intent);
                    break;
                }

                case R.id.alarm: {
                    Intent intent = new Intent(this, Alarm.class);
                    startActivity(intent);
                    break;
                }
                case R.id.corn: {
                    Intent intent = new Intent(this, JenisjagungActivity.class);
                    startActivity(intent);
                    break;
                }
                case R.id.artikel: {
                    Intent intent = new Intent(this, ArtikelActivity.class);
                    startActivity(intent);
                    break;
                }
            }
            return true;
        });
    }

    public void jagungmanis(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.jagungmanis: {
                intent = new Intent(this, JagungmanisActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}