package com.example.repository;

import com.example.model.Student;
import java.util.List; //usamos List porque los estudiantes se van a guardar en un Array
import java.util.ArrayList; //usamos ArrayList porque es una lista que puede crecer dinámicamente.
import org.springframework.stereotype.Repository; //importamos la anotación de Repository para que Spring lo reconozca como un bean de repositorio.

//Autowired inyecta dependencia, Qualifier dice que interfaz usar.
@Repository 
public class StudentRepositoryImpl implements IStudentRepository{
    private List<Student> students = new ArrayList<>(); //almacena los estudiantes en memoria, la clave es el id del estudiante y el valor es el objeto estudiante.

    @Override 
    public List<Student> findAll() { //devuelve todos los estudiantes guardados.
        return students;
    }

    @Override 
    public void save(Student student) { //guarda un estudiante nuevo
        students.add(student);
    }

    @Override 
    public Student findById(int studentId) {
        for (Student student : students) {
            if (student.getId() == studentId){
                return student;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int studentId){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == studentId) {
                students.remove(i);
                return;
            }
        }
    }

    @Override
    public void update(Student student){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == student.getId()) {
                students.set(i, student);
                return;
            }
        }
    }
}

