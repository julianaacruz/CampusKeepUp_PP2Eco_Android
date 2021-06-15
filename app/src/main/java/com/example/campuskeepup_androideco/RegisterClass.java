package com.example.campuskeepup_androideco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterClass extends AppCompatActivity implements View.OnClickListener {

    private EditText codeET;
    private Button registerClassBtn2, backHomeBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_class);

        registerClassBtn2 = findViewById(R.id.registerClassBtn2);
        backHomeBtn = findViewById(R.id.backHomeBtn);


        registerClassBtn2.setOnClickListener(this);
        backHomeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backHomeBtn: //Volver al home

                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                finish();

                break;
        }
    }
}