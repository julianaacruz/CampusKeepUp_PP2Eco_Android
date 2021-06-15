package com.example.campuskeepup_androideco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText emailET, passwordET;
    private TextView loginRegister;
    private FloatingActionButton loginBackBtn;
    private Button loginBtn;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailET = findViewById(R.id.emailET);
        passwordET = findViewById(R.id.passwordlET);
        loginRegister = findViewById(R.id.loginRegister);
        loginBtn = findViewById(R.id.loginBtn);
        loginBackBtn  = findViewById(R.id.loginBackBtn);

        auth = FirebaseAuth.getInstance();

        loginBtn.setOnClickListener(this);
        loginRegister.setOnClickListener(this);
        loginBackBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){


            case R.id.loginBackBtn: //Volver a anterior pantalla

                Intent i = new Intent(this, StartActivity.class);
                startActivity(i);
                finish();

                break;

            case R.id.loginRegister: //No tengo cuenta

                Intent n = new Intent(this, SignUpActivity.class);
                startActivity(n);
                finish();

                break;


            case R.id.loginBtn:
            auth.signInWithEmailAndPassword(emailET.getText().toString(), passwordET.getText().toString()).addOnCompleteListener(
                    task -> {
                        if(task.isSuccessful()){
                            Intent intent = new Intent(this, MainActivity.class);
                            startActivity(intent);
                            finish();

                        }else{
                            Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                        }

                    }
            );
                break;
        }
    }
}