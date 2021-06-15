package com.example.campuskeepup_androideco;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterClass extends AppCompatActivity implements View.OnClickListener {

    private EditText codeET;
    private Button registerClassBtn2;
    private FloatingActionButton backHomeBtn;
    private FirebaseDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_class);

        codeET = findViewById(R.id.codeET);
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

            case R.id.registerClassBtn2: //
                db.getReference().child("classes").child(codeET.getText().toString()).addListenerForSingleValueEvent(
                        new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                Classroom classroom = snapshot.getValue(Classroom.class);
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        }
                );

                break;
        }
    }
}