package com.example.campuskeepup_androideco;

import com.google.firebase.auth.FirebaseUser;

public class Student {
    private FirebaseUser id;
    private String name;
    private String email;
    private String password;

    public Student(String id, String name, String email, String password) {
    }

    public FirebaseUser getId() {
        return id;
    }

    public void setId(FirebaseUser id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student(FirebaseUser id) {
        this.id = id;
    }

    public Student(FirebaseUser id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
