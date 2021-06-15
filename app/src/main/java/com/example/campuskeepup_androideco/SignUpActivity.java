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
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameReg, emailReg, passwordReg, confirmPasReg;
    private TextView registerLogin;
    private Button registerBtn, registerGoogleBtn, registerBackBtn;
    private FirebaseAuth auth;
    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        nameReg = findViewById(R.id.nameReg);
        emailReg = findViewById(R.id.emailReg);
        passwordReg = findViewById(R.id.passwordReg);
        confirmPasReg = findViewById(R.id.confirmPasReg);
        registerLogin = findViewById(R.id.registerLogin);
        registerBtn = findViewById(R.id.registerBtn);
        registerGoogleBtn = findViewById(R.id.registerGoogleBtn);
        registerBackBtn = findViewById(R.id.registerBackBtn);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();

        registerBtn.setOnClickListener(this);
        registerLogin.setOnClickListener(this);
        registerBackBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.registerBackBtn: //Volver a anterior pantalla

                Intent i = new Intent(this, StartActivity.class);
                startActivity(i);
                finish();

                break;

            case R.id.registerLogin: //No tengo cuenta

                Intent n = new Intent(this, LoginActivity.class);
                startActivity(n);
                finish();

                break;

            case R.id.registerBtn:
                auth.createUserWithEmailAndPassword(emailReg.getText().toString(), passwordReg.getText().toString())
                .addOnCompleteListener(
                        task -> {
                            if (task.isSuccessful()){
                                String id = auth.getCurrentUser().getUid();
                                Student student = new Student(
                                        id,
                                        nameReg.getText().toString(),
                                        emailReg.getText().toString(),
                                        passwordReg.getText().toString()
                                        );
                                db.getReference().child("student").child(id).setValue(student).addOnCompleteListener( //Escribir estudiante en base de datos
                                        taskdb-> {
                                            if (taskdb.isSuccessful()){
                                                Intent intent = new Intent(this, MainActivity.class);
                                                startActivity(intent);
                                                finish();
                                            }
                                        }
                                );


                        }else{
                            Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                );
                break;
    }
}

}