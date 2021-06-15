package com.example.campuskeepup_androideco;

public class Classroom {

    private String id;
    private String name;
    private float promedio;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public Classroom(String s, String eco, String ecosistemas_de_aplicaciones, double v) {
    }

    public Classroom(String id, String name, float promedio) {
        this.id = id;
        this.name = name;
        this.promedio = promedio;
    }
}
