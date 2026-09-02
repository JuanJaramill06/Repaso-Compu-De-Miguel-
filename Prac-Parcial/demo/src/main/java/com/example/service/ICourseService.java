package com.example.service;

import com.example.model.Course;
import java.util.Collection;

public interface ICourseService {
    void addCourse(Course course); //agrega un curso nuevo
    Collection<Course> getAllCourses(); //devuelve todos los cursos guardados.
    Course getCourseById(int courseId); //devuelve el curso con ese Id.
    void deleteCourse(int courseId); //elimina el curso con ese Id.
    void updateCourse(Course course); //actualiza el curso con ese Id.
}
