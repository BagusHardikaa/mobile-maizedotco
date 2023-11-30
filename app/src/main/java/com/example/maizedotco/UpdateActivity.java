package com.example.maizedotco;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UpdateActivity extends AppCompatActivity {

    protected Cursor cursor;
    Database database;
    Button btn_simpan, btn_kembali;
    EditText nama, penyakit;
    private View btnmongo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        database = new Database(this);
        nama = findViewById(R.id.nama);
        penyakit = findViewById(R.id.penyakit);
        btn_simpan = findViewById(R.id.btn_simpan);
        btn_kembali = findViewById(R.id.btn_kembali);
        btnmongo = findViewById(R.id.btn_mongo);

        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM maizedotco WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            nama.setText(cursor.getString(0));
            penyakit.setText(cursor.getString(1));
        }

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Update local database
                SQLiteDatabase db = database.getWritableDatabase();
                db.execSQL("update maizedotco set nama='" +
                        nama.getText().toString() + "', penyakit='" +
                        penyakit.getText().toString() + "' where nama = '" +
                        getIntent().getStringExtra("nama") + "'");

                // Send data to MongoDB API
                sendUpdateToMongoDB();

                Toast.makeText(UpdateActivity.this, "Data berhasil diupdate", Toast.LENGTH_SHORT).show();
                ListActivity.ma.RefreshList();
                finish();
            }
        });

        btn_kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    protected void sendUpdateToMongoDB() {
        String urlEndpoint = "https://us-east-1.aws.data.mongodb-api.com/app/application-0-lygjy/endpoint/insertGejala";

        StringRequest request = new StringRequest(
                Request.Method.POST,
                urlEndpoint,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            // Handle the response from the server
                            JSONObject jsonResponse = new JSONObject(response);
                            // Add your code to handle the response as needed
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UpdateActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                // Add parameters to your request if needed
                Map<String, String> params = new HashMap<>();
                params.put("nama", nama.getText().toString());
                params.put("penyakit", penyakit.getText().toString());
                // Add other parameters as needed
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}
