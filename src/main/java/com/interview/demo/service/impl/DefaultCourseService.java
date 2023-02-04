package com.interview.demo.service.impl;

import com.interview.demo.entity.Course;
import com.interview.demo.entity.CourseStudent;
import com.interview.demo.entity.CourseStudentKey;
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
    public void gradeStudent(final Long courseId, Long studentId, final int grade) {
        var course = courseRepository.findById(courseId).orElseThrow(() ->  new EntityNotFoundException("Course not Found"));
        var student = studentRepository.findById(studentId).orElseThrow(() -> new EntityNotFoundException("Student Not Found"));
        var courseStudent = courseStudentRepository.findByCourseAndStudent(course, student);

        courseStudent.ifPresentOrElse(cu -> {
            saveGrade(cu, grade);
        }, () -> {
            var cu = new CourseStudent();
            cu.setId(getKey(course.getId(), student.getId()));
            cu.setCourse(course);
            cu.setStudent(student);
            saveGrade(cu, grade);
        });
    }

    private void saveGrade(final CourseStudent courseStudent, final int grade){
        courseStudent.setGrade(grade);
        courseStudentRepository.save(courseStudent);
    }

    private static CourseStudentKey getKey(final long courseId, final long studentId){
        CourseStudentKey key = new CourseStudentKey();
        key.setCourseId(courseId);
        key.setStudentId(studentId);
        return key;
    }

}
