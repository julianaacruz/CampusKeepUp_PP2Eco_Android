package com.example.campuskeepup_androideco;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.ArrayList;
import java.util.UUID;

public class ClassroomAdapter extends BaseAdapter {

    //Data
    private ArrayList<Classroom> classrooms;

    public ClassroomAdapter(){
        classrooms = new ArrayList<>();
        classrooms.add(new Classroom(UUID.randomUUID().toString(), "ECO", "Ecosistemas de aplicaciones", 4.4));

    }


    @Override
    public int getCount() {
        return classrooms.size();
    }

    @Override
    public Object getItem(int position) {
        return classrooms.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View renglon = inflater.inflate(R.layout.row, null);

      /*  Classroom classroom = classrooms.get(position);

        Button buttonRow = renglon.findViewById(R.id.buttonRow);
        Button nombreRow = renglon.findViewById(R.id.nombreRow);
        Button horarioRow = renglon.findViewById(R.id.horarioRow);


        nombreRow.setText(classroom.getName());
        horarioRow.setText(classroom.getId());*/


        return renglon;
    }
}
