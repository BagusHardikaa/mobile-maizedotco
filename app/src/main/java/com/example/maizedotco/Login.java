package com.example.maizedotco;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_signup);
    }
    public void btnlogin(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
    public void btnsignup(View view) {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
}