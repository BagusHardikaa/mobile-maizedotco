package com.example.maizedotco;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuJekit extends AppCompatActivity {

    Button btn_start, btn_info, btn_mongo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_jekit);

        btn_start = findViewById(R.id.btnstart);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuJekit.this, Diagnosa.class);
                startActivity(intent);

            }
        });

        btn_info = findViewById(R.id.btn_info);
        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuJekit.this, Penyakit.class);
                startActivity(intent);
            }
        });

        btn_mongo = findViewById(R.id.btn_mongo);
        btn_mongo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuJekit.this, MongoDB.class);
                startActivity(intent);
            }
        });
    }
}