package com.example.model;

public class Student {
    private int id;
    private String code;
    private String name;
    private String program;
    private int courseId;

    public Student() { 
    }

    public Student(int id, String code, String name, String program, int courseId) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.program = program;
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", code=" + code + ", name=" + name + ", program=" + program + ", courseId="
                + courseId + "]";
    }
 
}
