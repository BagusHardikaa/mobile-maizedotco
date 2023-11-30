package com.example.maizedotco;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

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
                case R.id.penyakit: {
                    Intent intent = new Intent(this, MenuJekit.class);
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

    public void btntopik(View view) {
        // Intent for the btntopik button
        Intent intent = new Intent(this, Home1.class);
        startActivity(intent);
    }

    public void fiturjekit(View view) {
        // Intent for the fiturjekit button
        Intent intent = new Intent(this, Home2.class);
        startActivity(intent);
    }

    public void fiturtaskminder(View view) {
        // Intent for the btnfiturtaskminder button
        Intent intent = new Intent(this, Home3.class);
        startActivity(intent);
    }
}
