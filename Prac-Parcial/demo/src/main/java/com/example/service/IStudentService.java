package com.example.service;

import com.example.model.Student;
import java.util.List;

public interface IStudentService {
    void addStudent(Student student); //agrega un estudiante nuevo
    List<Student> getStudents(); //devuelve todos los estudiantes guardados.
    Student getStudentById(int studentId); //devuelve el estudiante con ese Id.
    void deleteStudent(int studentId); //elimina el estudiante con ese Id.
    void updateStudent(Student student); //actualiza el estudiante con ese Id.
}
