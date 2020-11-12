package funix.prm.prm391x_alarmclock_thanhchfx01399;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button btnAdd;

    // Xu ly khi item tren menu duoc chon
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                // Chuyen man hinh activity
                Intent intent = new Intent(MainActivity.this, AlarmManagerActivity.class);
                startActivity(intent);
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Anh xa
        btnAdd = findViewById(R.id.btnAdd);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setTitle("Alarm Clock");

        // Chuyen ve trang truoc khi nhan nut back tren menu
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbar.setTitle("Alarm Clock");
                onBackPressed();
            }
        });

        TimeData mDB = new TimeData(getBaseContext());
        ArrayList<AlarmClock> listAlarm = (ArrayList<AlarmClock>) mDB.getAllAlarm();
        AlarmAdapter alarmAdapter = new AlarmAdapter(listAlarm);

        // Anh xa listview
        ListView listViewAlarm = findViewById(R.id.list);

        // set adapter cho listviewAlarm
        listViewAlarm.setAdapter(alarmAdapter);

        // Xu ly khi click nut add
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AlarmManagerActivity.class);
                startActivity(intent);
            }
        });
    }
}
