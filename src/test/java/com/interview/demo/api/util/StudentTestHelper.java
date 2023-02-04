package com.interview.demo.api.util;

import com.interview.demo.entity.Student;
import com.interview.demo.repository.StudentRepository;

public class StudentTestHelper {

    public static Student buildAndSave(final StudentRepository studentRepository, final String firstName, final String lastName) {
        var student = new Student();
        student.setFirstname(firstName);
        student.setLastname(lastName);
        studentRepository.saveAndFlush(student);
        return student;
    }
}
