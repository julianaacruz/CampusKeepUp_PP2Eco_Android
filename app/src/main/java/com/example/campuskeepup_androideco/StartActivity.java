package com.example.campuskeepup_androideco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    private Button registerBtn1, loginBtn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        registerBtn1 = findViewById(R.id.registerBtn1);
        loginBtn1 = findViewById(R.id.loginBtn1);


        registerBtn1.setOnClickListener(this);
        loginBtn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.registerBtn1: //Registarme

                Intent i = new Intent(this, SignUpActivity.class);
                startActivity(i);
                finish();


                break;

            case R.id.loginBtn1: //Registarme

                Intent n = new Intent(this, LoginActivity.class);
                startActivity(n);
                finish();
                break;

        }

    }
}