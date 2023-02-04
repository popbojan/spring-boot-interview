package com.interview.demo.api.util;

import com.interview.demo.entity.Course;
import com.interview.demo.entity.CourseStudent;
import com.interview.demo.entity.Student;
import com.interview.demo.repository.CourseStudentRepository;
import org.apache.commons.lang3.RandomUtils;

public class CourseStudentTestHelper {

    public static CourseStudent buildAndSave(final CourseStudentRepository courseStudentRepository, final Course course,
            final Student student) {
        return buildAndSave(courseStudentRepository, course, student, null);
    }

    public static CourseStudent buildAndSave(final CourseStudentRepository courseStudentRepository, final Course course,
            final Student student, final Integer grade) {
        var courseStudent = new CourseStudent();
        courseStudent.setCourse(course);
        courseStudent.setStudent(student);
        courseStudent.setGrade(grade != null ? grade : RandomUtils.nextInt(1, 5));
        courseStudentRepository.saveAndFlush(courseStudent);
        return courseStudent;
    }
}
