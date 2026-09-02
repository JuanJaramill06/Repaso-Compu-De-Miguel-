package com.example.model;

public class Course {
    private int id;
    private String name;
    private String professorName;
    private String schedule;

    public Course() { //Constructor vacío es para agregar datos uno por uno usando setters, cuando no tengo los datos disponibles al mismo tiempo.
    }

    public Course(int id, String name, String professorName, String schedule) {
        this.id = id;
        this.name = name;
        this.professorName = professorName;
        this.schedule = schedule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() { //En el Servlet cuando se menciona la clase, llama es el toString par que muestre todo como un texto plano.
        return "Course [id=" + id + ", name=" + name + ", professorName=" + professorName + ", schedule=" + schedule
                + "]";
    }
    
}
