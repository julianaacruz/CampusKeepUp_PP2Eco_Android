package com.example.campuskeepup_androideco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button registerClassBtn;

    private FirebaseDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerClassBtn = findViewById(R.id.registerClassBtn);


        registerClassBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.registerClassBtn: //Registrar mi clase

                Intent i = new Intent(this, RegisterClass.class);
                startActivity(i);
                finish();

                break;}
    }
}