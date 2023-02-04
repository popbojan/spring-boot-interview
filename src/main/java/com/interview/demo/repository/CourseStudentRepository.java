package com.interview.demo.repository;

import com.interview.demo.entity.Course;
import com.interview.demo.entity.CourseStudent;
import com.interview.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseStudentRepository extends JpaRepository<CourseStudent, Long> {

    Optional<CourseStudent> findByCourseAndStudent(Course course, Student student);
}
