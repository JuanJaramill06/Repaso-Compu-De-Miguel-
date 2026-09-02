package com.example.service;

import com.example.model.Course;
import java.util.Collection;
import org.springframework.stereotype.Service;
import com.example.repository.ICourseRepository;

@Service 
public class CourseServiceImpl implements ICourseService {
    private final ICourseRepository courseRepository;
    
    public CourseServiceImpl(ICourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    @Override 
    public Collection<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override 
    public Course getCourseById(int courseId) {
        return courseRepository.findById(courseId);
    }

    @Override
    public void deleteCourse(int courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public void updateCourse(Course course) {
        courseRepository.update(course);
    }
}
