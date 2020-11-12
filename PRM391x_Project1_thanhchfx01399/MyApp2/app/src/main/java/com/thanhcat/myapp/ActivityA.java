package com.thanhcat.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityA extends AppCompatActivity {

    EditText edt;
    Button btnStart;
    public static final String NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        // Anh xa
        edt = (EditText) findViewById(R.id.inputName);
        btnStart = (Button) findViewById(R.id.btnStart);

        // Su kien khi bam nut
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byExtra();
            }
        });
    }

    //Chuyen man hinh va truyen du lieu nhap o activity A sang activity B
    public void byExtra() {
        Intent intent = new Intent(ActivityA.this, ActivityB.class);
        intent.putExtra(NAME, edt.getText().toString());
        startActivity(intent);
    }
}
