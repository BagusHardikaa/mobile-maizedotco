package com.example.maizedotco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME ="maizedotco.db";
    private static final int DATABASE_VERSION = 1;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    String sql = "create table maizedotco(nama text null, penyakit text null);";
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("Data", "onCreate" + sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db0, int db1, int db2) {

    }
}