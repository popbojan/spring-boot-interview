package com.interview.demo.service;

import com.interview.demo.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    List<Course> findByName(String name);

    void gradeCourse(Long courseId, Long studentId, int grade);
}

