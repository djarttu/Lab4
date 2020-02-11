package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class WorkOutClock extends AppCompatActivity {
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_out_clock);
        Intent intent=getIntent();
        String aika=intent.getStringExtra("AIKA");
        String nimi = intent.getStringExtra("NIMI");
        final TextView text = findViewById(R.id.timeField);
        TextView text2 =findViewById(R.id.nameField);
        text.setText(aika);
        text2.setText(nimi);
        try{
            i = Integer.parseInt(aika.trim());

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        new CountDownTimer(i * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                i = i - 1;
                text.setText(String.valueOf(i));



            }

            @Override
            public void onFinish() {

                WorkOutClock.this.finish();
            }

        }.start();
    }
}
