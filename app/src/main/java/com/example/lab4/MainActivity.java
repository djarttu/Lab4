package com.example.lab4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int ADD_NEW_PART_INTENT_ID=8976;
    ArrayList<WorkOutPart> fullworkout = new ArrayList<>();
    ListView simpleList;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.startButton).setOnClickListener(this);
    simpleList = (ListView) findViewById(R.id.simpleList);
    myAdapter = new MyAdapter(this, R.layout.list_view_items, fullworkout);
    simpleList.setAdapter(myAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.newButton) {

            createNewWorkOut();
            return true;
        }
        else
            return super.onOptionsItemSelected(item);
    }
    public void createNewWorkOut(){
        Intent intent = new Intent(this, activity_createWorkout.class);
        startActivityForResult(intent, ADD_NEW_PART_INTENT_ID);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==ADD_NEW_PART_INTENT_ID && resultCode== Activity.RESULT_OK) {

            WorkOutPart newPart=(WorkOutPart) data.getSerializableExtra("NEW_PART");


            fullworkout.add(newPart);
            myAdapter.notifyDataSetChanged();

        }
    }
    @Override
    public void onClick(View v) {
        Collections.reverse(fullworkout);
                 for(int i =0; i<fullworkout.size();i++) {
                     String nimi = fullworkout.get(i).getName();
                     int aika = fullworkout.get(i).getSeconds();
                     String aika2 = Integer.valueOf(aika).toString();
                     Intent intent =new Intent(this, WorkOutClock.class);
                     intent.putExtra("NIMI",nimi);
                     intent.putExtra("AIKA",aika2);
                     startActivity(intent);

                 }
    }
}

