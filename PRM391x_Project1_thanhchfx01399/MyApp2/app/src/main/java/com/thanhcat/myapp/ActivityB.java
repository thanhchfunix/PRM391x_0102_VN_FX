package com.thanhcat.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ActivityB extends AppCompatActivity {

    TextView tvName, tvTime;
    Button btnBack, btnSubmit;
    CountDownTimer w;
    RadioButton radBtn4, radBtn7, radBtn10, radBtn13;
    CheckBox cb1,cb2,cb3;
    EditText edt1;
    static Integer kq;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        // Anh xa
        tvName = (TextView)findViewById(R.id.tvName);// Ten nguoi lam quizz

        tvTime = (TextView)findViewById(R.id.tvTime);// Hien thi thoi gian

        btnBack = (Button)findViewById(R.id.btnBack);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        radBtn4 = (RadioButton)findViewById(R.id.radioButton4);
        radBtn7 = (RadioButton)findViewById(R.id.radioButton7);
        radBtn10 = (RadioButton)findViewById(R.id.radioButton10);
        radBtn13 = (RadioButton)findViewById(R.id.radioButton13);
        cb1 = (CheckBox)findViewById(R.id.checkBox1);
        cb2 = (CheckBox)findViewById(R.id.checkBox2);
        cb3 = (CheckBox)findViewById(R.id.checkBox3);
        edt1 = (EditText)findViewById(R.id.edt1);

        // Nhan du lieu tu activity A
        byReceive();

        // goi countdown timer time 30s
        w = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String time = Long.toString(millisUntilFinished/1000);
                tvTime.setText(time);
            }

            // goi khi dem xong countdown timer ve 0
            @Override
            public void onFinish() {
                score();
                Toast.makeText(ActivityB.this, "Time out! Your result is " +
                        Integer.toString(kq) + "/6", Toast.LENGTH_SHORT ).show();
            }
        }.start();

        // Su kien khi nhan nut submit
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dung chay countdown timer
                w.cancel();

                // Tinh diem
                score();
                result = "Your result: " + Integer.toString(kq) + "/6";

                // Hien thi diem
                Toast.makeText(ActivityB.this, result, Toast.LENGTH_SHORT).show();
            }
        });

        // Su kien khi nhan nut back
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityB.this, ActivityA.class);
                startActivity(intent);
            }
        });

    }

    // Nhan du lieu tu activity A
    public void byReceive() {
        Intent intent = getIntent();
        tvName.setText(intent.getStringExtra(ActivityA.NAME));
    }

    // Tinh diem cua nguoi lam quizz
    public void score() {
        kq = 0;
        kq = radBtn4.isChecked() ? kq+1 : kq;
        kq = radBtn7.isChecked() ? kq+1 : kq;
        kq = radBtn10.isChecked() ? kq+1 : kq;
        kq = edt1.getText().toString().equals("3.0") ? kq+1 : kq;
        kq = ((cb1.isChecked()) && (cb2.isChecked()) && (!cb3.isChecked())) ? kq+1 : kq;
        kq = radBtn13.isChecked() ? kq+1 : kq;
    }
}
