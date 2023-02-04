package com.interview.demo.api;

import com.interview.demo.api.util.CourseStudentTestHelper;
import com.interview.demo.api.util.CourseTestHelper;
import com.interview.demo.api.util.StudentTestHelper;
import com.interview.demo.repository.CourseRepository;
import com.interview.demo.repository.CourseStudentRepository;
import com.interview.demo.repository.StudentRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public final class CourseControllerGradeStudentTests {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseStudentRepository courseStudentRepository;

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {
        courseStudentRepository.deleteAll();
        courseRepository.deleteAll();
        studentRepository.deleteAll();
    }

    //@Test
    public void gradeStudent(){

        final var courseName = RandomStringUtils.random(20);
        final var studentGrade = 2;
        final var firstName = RandomStringUtils.random(20);
        final var lastName = RandomStringUtils.random(20);

        final var course = CourseTestHelper.buildAndSave(courseRepository, courseName);
        final var student = StudentTestHelper.buildAndSave(studentRepository, firstName, lastName);
        CourseStudentTestHelper.buildAndSave(courseStudentRepository, course, student, studentGrade);

        var response = CourseTestHelper.gradeStudentSuccessful(course.getId(), student.getId(), studentGrade,
                CourseTestHelper.getURL(port));

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);


    }

}
