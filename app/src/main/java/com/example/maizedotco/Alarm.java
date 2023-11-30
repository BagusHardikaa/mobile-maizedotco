package com.example.maizedotco;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;
import java.util.Date;

public class Alarm extends AppCompatActivity {

    private TimePicker timePicker;
    private Button startAlarm;
    private int jam, menit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

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

        // Menambahkan bagian kode untuk inisialisasi komponen pada layout home
        timePicker = findViewById(R.id.timePicker);
        startAlarm = findViewById(R.id.startAlarm);

        timePicker.setOnTimeChangedListener((view, hourOfDay, minute) -> {
            jam = hourOfDay;
            menit = minute;
        });

        startAlarm.setOnClickListener(v -> {
            Toast.makeText(Alarm.this, "Set Alarm " + jam + " : " + menit, Toast.LENGTH_SHORT).show();
            setTimer();
            notification();
        });
    }

    private void notification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "WAKTUNYA MERAWAT JAGUNGMU";
            String description = "Siram dan beri pupuk tanaman jagung yuk!";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel("Notify", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void setTimer() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Date date = new Date();

        Calendar cal_alarm = Calendar.getInstance();
        Calendar cal_now = Calendar.getInstance();

        cal_now.setTime(date);
        cal_alarm.setTime(date);

        cal_alarm.set(Calendar.HOUR_OF_DAY, jam);
        cal_alarm.set(Calendar.MINUTE, menit);
        cal_alarm.set(Calendar.SECOND, 0);

        if (cal_alarm.before(cal_now)) {
            cal_alarm.add(Calendar.DATE, 1);
        }

        Intent i = new Intent(Alarm.this, MyBroadcastReceiver.class);

        // Tambahkan FLAG_MUTABLE atau FLAG_IMMUTABLE sesuai kebutuhan
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                Alarm.this,
                0,
                i,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_MUTABLE // Gantilah ini sesuai kebutuhan
        );

        alarmManager.set(AlarmManager.RTC_WAKEUP, cal_alarm.getTimeInMillis(), pendingIntent);
    }
}
