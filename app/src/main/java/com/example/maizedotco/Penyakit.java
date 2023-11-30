package com.example.maizedotco;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class Penyakit extends Activity {

    ListView simpleList;
    Button btn_kembali;

    String[] countryList = {"Bulai", "Karat Daun", "Bercak Daun", "Hawar Daun", "Busuk Pelepah", "Busuk Batang", "Gosong", "Mosaik Jagung"};
    int flags[] = {R.drawable.bulai_jagung, R.drawable.karat_daun, R.drawable.bercak_daun, R.drawable.hawar_daun, R.drawable.busuk_pelepah, R.drawable.busuk_batang, R.drawable.gosong, R.drawable.mosaik_jagung};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penyakit);
        simpleList = findViewById(R.id.simpleListView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), countryList, flags);
        simpleList.setAdapter(customAdapter);
        btn_kembali = findViewById(R.id.btn_kembali);

        // Set listener untuk menangani klik item pada ListView
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Ketika item diklik, buat Intent untuk membuka DetailActivityPenyakit
                Intent intent = new Intent(Penyakit.this, DetailActivityPenyakit.class);

                // Kirim data nama penyakit atau ID ke DetailActivityPenyakit
                intent.putExtra("nama_penyakit", countryList[position]);
                System.out.println(countryList[position]);

                // Mulai aktivitas baru
                startActivity(intent);
            }
        });

        btn_kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // Tutup activity Penyakit dan kembali ke activity sebelumnya
            }
        });
    }
}