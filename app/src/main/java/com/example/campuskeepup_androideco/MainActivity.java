package com.example.campuskeepup_androideco;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button registerClassBtn;
    private ListView classList;
    private FirebaseAuth auth;
    private FirebaseDatabase db;
    private Student student;
    private ClassroomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerClassBtn = findViewById(R.id.registerClassBtn);
        classList = findViewById(R.id.classList);

       adapter = new ClassroomAdapter();
      classList.setAdapter(adapter);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        recoverUser();


        registerClassBtn.setOnClickListener(this);

    }

    private void recoverUser() {
        if( auth.getCurrentUser() != null){
            String id = auth.getCurrentUser().getUid();
            db.getReference().child("student").child(id).addListenerForSingleValueEvent( //ONCE
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            student = snapshot.getValue(Student.class);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    }
            );
        }
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