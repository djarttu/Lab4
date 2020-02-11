package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class activity_createWorkout extends AppCompatActivity implements View.OnClickListener {
    boolean Pause = false;
    CheckBox checkBox;
    EditText editor;
    EditText editor2;
    int aika;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_workout);
        findViewById(R.id.addButton).setOnClickListener(this);
        editor = findViewById(R.id.laji);
        editor2 = findViewById(R.id.time);
       checkBox=findViewById(R.id.cb);
    }

    @Override
    public void onClick(View v) {

        String text = editor.getText().toString();
        if (Pause)
            text = "Pause";

        getTime();
        if(aika==0){
            editor2.setText(null);
            editor.setText(null);
            return;}
        WorkOutPart part = new WorkOutPart(aika, text);
        Intent resultIntent = new Intent();
        resultIntent.putExtra("NEW_PART", part);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public void onCheckBoxClicked(View v) {
        if (checkBox.isChecked()) {
            Pause = true;
            editor.setEnabled(false);
            editor.setText(null);
        }
        else{
            Pause=false;
            editor.setEnabled(true);
        }


    }
    public void getTime(){
        try {
            aika = Integer.parseInt(editor2.getText().toString());
        }
        catch (NumberFormatException e) {
            aika=0;
        }

    }
}