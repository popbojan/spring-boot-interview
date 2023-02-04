package com.interview.demo.service.impl;

import com.interview.demo.entity.Course;
import com.interview.demo.entity.CourseStudent;
import com.interview.demo.repository.CourseRepository;
import com.interview.demo.repository.CourseStudentRepository;
import com.interview.demo.repository.StudentRepository;
import com.interview.demo.service.CourseService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCourseService implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseStudentRepository courseStudentRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> findByName(final String name) {
        return courseRepository.findByNameContaining(name);
    }

    @Override
    @Transactional
    public void gradeCourse(final Long courseId, Long studentId, final int grade) {
        var course = courseRepository.findById(courseId).orElseThrow(() ->  new EntityNotFoundException("Course not Found"));
        var student = studentRepository.findById(studentId).orElseThrow(() -> new EntityNotFoundException("Student Not Found"));
        var courseUser = courseStudentRepository.findByCourseAndStudent(course, student);

        courseUser.ifPresentOrElse(cu -> {
            cu.setGrade(grade);
            courseStudentRepository.save(cu);
        }, () -> {
            var cu = new CourseStudent();
            cu.setCourse(course);
            cu.setStudent(student);
            cu.setGrade(grade);
        });
    }

}
