package funix.prm.prm391x_alarmclock_thanhchfx01399;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AlarmManagerActivity extends AppCompatActivity {

    Button btnStart;
    TimePicker timePicker;
    Calendar calendar;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_manager);

        timePicker = findViewById(R.id.timePicker);

        // set che do time picker 24h
        timePicker.setIs24HourView(true);

        calendar = Calendar.getInstance();
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                // set va lay du lieu tu timepicker
                calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
                calendar.set(Calendar.MINUTE, timePicker.getMinute());
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();

                // Them du lieu vao SQlite
                TimeData mDB = new TimeData(getApplicationContext());
                AlarmClock alarmClock = new AlarmClock();
                alarmClock.setHour(hour);
                alarmClock.setMinute(minute);
                alarmClock.setStatus("on");
                int id = (int) mDB.addAlarm(alarmClock);
                Toast.makeText(getBaseContext(), "Add Alarm to DB success: " + id, Toast.LENGTH_SHORT).show();

                // Khoi tao pendingIntent
                Intent intent = new Intent(AlarmManagerActivity.this, AlarmReceiver.class);

                intent.putExtra("extra", "on");
                pendingIntent = PendingIntent.getBroadcast(
                        AlarmManagerActivity.this,
                        id,
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

                // Chuyen man hinh
                intent = new Intent(AlarmManagerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
