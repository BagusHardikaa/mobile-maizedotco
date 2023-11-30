package com.example.maizedotco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MongoDB extends AppCompatActivity {

    TextView tvResult;
    Button btn_kembali, btn_mongo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mongo);

        tvResult = findViewById(R.id.tvResult);
        btn_mongo = findViewById(R.id.btn_mongo);

        btn_mongo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAllPenyakit(view);
            }
        });
    }

    public void getAllPenyakit(View view) {
        String urlEndpoint = "https://us-east-1.aws.data.mongodb-api.com/app/application-0-lygjy/endpoint/getAllPenyakit";
        StringRequest sr = new StringRequest(
                Request.Method.GET,
                urlEndpoint,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            // Parse the JSON response
                            JSONObject hasil = new JSONObject(response);
                            JSONArray result = hasil.getJSONArray("result");

                            // Clear existing text in tvResult
                            tvResult.setText("");

                            // Iterate through the array and append data to tvResult
                            for (int i = 0; i < result.length(); i++) {
                                JSONObject penyakit = result.getJSONObject(i);
                                String namaPenyakit = penyakit.getString("nama_penyakit");
                                String deskripsi = penyakit.getString("deskripsi");
                                String solusi = penyakit.getString("solusi");

                                // Append data to tvResult
                                tvResult.append("Nama Penyakit: " + namaPenyakit + "\n");
                                tvResult.append("Deskripsi: " + deskripsi + "\n");
                                tvResult.append("Solusi: " + solusi + "\n\n");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(MongoDB.this, "Error parsing JSON", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle errors
                        Toast.makeText(MongoDB.this, "Error: " + error.toString().trim(), Toast.LENGTH_SHORT).show();
                    }
                }
        );

        // Add the request to the RequestQueue
        RequestQueue rq = Volley.newRequestQueue(getApplicationContext());
        rq.add(sr);
    }
}