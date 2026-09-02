package com.example.repository;

import com.example.model.Course;
import java.util.Collection;

public interface ICourseRepository {
    Collection<Course> findAll(); //devuelve todos los cursos guardados.
    void save(Course couser); //guarda un curso nuevo
    boolean existById(int courseId); //verifica si existe un curso con ese Id.
    Course findById(int courseId); //devuelve el curso con ese Id.
    void deleteById(int courseId); //elimina el curso con ese Id.
    void update(Course course); //actualiza el curso con ese Id.
}
