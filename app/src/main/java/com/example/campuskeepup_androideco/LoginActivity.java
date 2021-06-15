package com.example.campuskeepup_androideco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText emailET, passwordET;
    private TextView loginResgiter;
    private Button loginBtn;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailET = findViewById(R.id.emailET);
        passwordET = findViewById(R.id.passwordlET);
        loginResgiter = findViewById(R.id.loginRegister);
        loginBtn = findViewById(R.id.loginBtn);

        auth = FirebaseAuth.getInstance();

        loginBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginRegister: //No tengo cuenta

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