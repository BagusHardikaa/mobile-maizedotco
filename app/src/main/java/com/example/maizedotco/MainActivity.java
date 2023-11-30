package com.example.maizedotco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static ListActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampilan_logo);

    }

    public void login(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.login: {
                intent = new Intent(this, Login.class);
                startActivity(intent);
                break;
            }
        }
    }
}