package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class activity_createWorkout extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_workout);
        findViewById(R.id.addButton).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText editor=findViewById(R.id.laji);
        String text = editor.getText().toString();
        EditText editor2 = findViewById(R.id.time);
        int aika =  Integer.parseInt(editor2.getText().toString());
        WorkOutPart part = new WorkOutPart(aika, text);
        Intent resultIntent=new Intent();
        resultIntent.putExtra("NEW_PART",part);
        setResult(Activity.RESULT_OK,resultIntent);
        finish();
    }
}
