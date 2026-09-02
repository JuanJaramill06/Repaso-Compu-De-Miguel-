package com.example.repository;

import com.example.model.Student;
import java.util.List; //usamos List porque los estudiantes se van a guardar en un ArrayList, donde el orden importa.

public interface IStudentRepository {
    List<Student> findAll(); //devuelve todos los estudiantes guardados.
    void save(Student student); //guarda un estudiante nuevo
    Student findById(int studentId); //devuelve el estudiante con ese Id.
    void deleteById(int studentId); //elimina el estudiante con ese Id.
    void update(Student student); //actualiza el estudiante con ese Id.
}
