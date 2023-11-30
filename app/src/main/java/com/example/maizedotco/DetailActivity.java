package com.example.maizedotco;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    protected Cursor cursor;
    Database database;
    Button btn_kembali;
    TextView nama, penyakit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        database = new Database(this);
        nama = findViewById(R.id.nama);
        penyakit = findViewById(R.id.penyakit);
        btn_kembali = findViewById(R.id.btn_kembali);

        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM maizedotco WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();
        if(cursor.getCount() >0){
            cursor.moveToPosition(0);
            nama.setText(cursor.getString(0).toString());
            penyakit.setText(cursor.getString(1).toString());
        }

        btn_kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // Tutup CreateActivity dan kembali ke MainActivity
            }
        });
    }
}