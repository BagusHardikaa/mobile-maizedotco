package com.example.maizedotco;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ArtikelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel);

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

        ImageView imageView1 = findViewById(R.id.artikel1);
        ImageView imageView2 = findViewById(R.id.artikel2);
        ImageView imageView3 = findViewById(R.id.artikel3);

        // Tambahkan listener untuk ImageView artikel1
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Panggil metode saat artikel1 diklik
                onClickArtikel1(v);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Panggil metode saat artikel1 diklik
                onClickArtikel2(v);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Panggil metode saat artikel1 diklik
                onClickArtikel3(v);
            }
        });
    }

    // Metode yang akan dipanggil saat artikel1 diklik
    public void onClickArtikel1(View view) {
        // Membuat Intent untuk memulai Artikel1Activity
        Intent intent = new Intent(this, artikel1.class);
        startActivity(intent);
    }

    public void onClickArtikel2(View view) {
        // Membuat Intent untuk memulai Artikel1Activity
        Intent intent = new Intent(this, artikel2.class);
        startActivity(intent);
    }

    public void onClickArtikel3(View view) {
        // Membuat Intent untuk memulai Artikel1Activity
        Intent intent = new Intent(this, artikel3.class);
        startActivity(intent);
    }
}
