package com.example.repository;

import com.example.model.Course;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository; //PostConstruct es la anotación que marca un metodo para que spring lo ejecute automaticamente justo despues de crear el bean.
import java.util.Collection;
import java.util.HashMap; //estructura donde vamos a guardar los cursos en memoria.

@Repository //Clase como bean.
public class CourseRepositoryImpl implements ICourseRepository {
    private HashMap<Integer, Course> courses; //almacena los cursos en memoria, la clave es el id del curso y el valor es el objeto curso.

    public CourseRepositoryImpl() { //constructor inicializa el HashMap vacio.
        courses = new HashMap<>();
    }

    @Override
    public Collection<Course> findAll() { //devuelve todos los cursos guardados.
        return courses.values();
    }

    @Override
    public void save(Course course) { //guarda un curso nuevo
        courses.put(course.getId(), course);
    }

    @Override
    public boolean existById(int courseId) { //verifica si existe un curso con ese Id.
        return courses.containsKey(courseId); //ContainsKey es un metodo que valida si existe una llave en el mapa.     
    }

    @Override 
    public Course findById(int courseId) {
        return courses.get(courseId); //Get es un metodo que devuelve el valor de la llave en el mapa.
    }

    @Override 
    public void deleteById(int courseId) {
        courses.remove(courseId); //Remove es un metodo que elimina la llave y su valor del mapa.
    }

    @Override 
    public void update(Course course){
        courses.put(course.getId(), course); //Put es un metodo que agrega o actualiza la llave y su valor en el mapa.
    }

    @PostConstruct //Este metodo se ejecuta automaticamente despues de crear el bean, para inicializar los datos de prueba.
    public void init() {
        Course a = new Course();
        a.setId(1);
        a.setName("Computación en internet II");
        a.setProfessorName("kevin Rodriguez");
        a.setSchedule("Ma Ju 2PM a 4PM");
        courses.put(a.getId(), a);

        Course b = new Course();
        b.setId(2);
        b.setName("Estructura Discretas II");
        b.setProfessorName("Juan Marcos Caicedo");
        b.setSchedule("MA JU 4PM a 6PM");
        courses.put(b.getId(), b);
    }
}
