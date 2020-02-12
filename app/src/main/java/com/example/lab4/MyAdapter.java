package com.example.lab4;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<WorkOutPart> {
    ArrayList<WorkOutPart> fullworkout = new ArrayList<>();

    public MyAdapter(Context context, int textViewResourceId, ArrayList<WorkOutPart> objects) {
        super(context, textViewResourceId, objects);
        fullworkout = objects;
    }

    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.list_view_items, null);
        TextView nimi = (TextView) v.findViewById(R.id.harjNimi);
        TextView aika = (TextView) v.findViewById(R.id.harjAika);
        nimi.setText(fullworkout.get(position).getName());
        if(fullworkout.get(position).getName().contentEquals("Pause")) {
            //nimi.setBackgroundColor(Color.CYAN);
            //aika.setBackgroundColor(Color.CYAN);
            v.setBackgroundColor(Color.CYAN);
        }
        else{
            v.setBackgroundColor(Color.RED);
            //nimi.setBackgroundColor(Color.RED);
            //aika.setBackgroundColor(Color.RED);
        }

        aika.setText(String.valueOf(fullworkout.get(position).getSeconds()));
        return v;
    }
}