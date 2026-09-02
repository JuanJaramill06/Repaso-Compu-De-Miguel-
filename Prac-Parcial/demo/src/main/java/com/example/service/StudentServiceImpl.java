package com.example.service;

import com.example.model.Student;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.repository.IStudentRepository;
import com.example.repository.ICourseRepository;

@Service 
public class StudentServiceImpl implements IStudentService{
    private final IStudentRepository studentRepository;
    private final ICourseRepository courseRepository;

    public StudentServiceImpl(IStudentRepository studentRepository, ICourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override 
    public void addStudent(Student student) {
        if (courseRepository.existById(student.getCourseId())) { //verifica si existe un curso con ese Id.
            studentRepository.save(student);
            System.out.println("Guardado correctamente");
        } else {
            System.out.println("Curso no existe");
        }
    }
    
    @Override 
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public void deleteStudent(int studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.update(student);
    }

}