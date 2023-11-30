package com.example.maizedotco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class JenisjagungActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jenisjagung);

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

    public void jagungmanis(View view) {
        Intent intent = new Intent(this, JagungmanisActivity.class);
        startActivity(intent);
    }
    public void jagungpolong(View view) {
        Intent intent = new Intent(this, JagungpolongActivity.class);
        startActivity(intent);
    }
    public void jagunggigikuda(View view) {
        Intent intent = new Intent(this, JagunggigikudaActivity.class);
        startActivity(intent);
    }
    public void jagungketan(View view) {
        Intent intent = new Intent(this, JagungketanActivity.class);
        startActivity(intent);
    }
    public void jagungberondong(View view) {
        Intent intent = new Intent(this, BerondongActivity.class);
        startActivity(intent);
    }
    public void jagungmutiara(View view) {
        Intent intent = new Intent(this, MutiaraActivity.class);
        startActivity(intent);
    }

}
