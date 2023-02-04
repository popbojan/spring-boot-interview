package com.interview.demo.api;

import com.interview.demo.api.util.CourseTestHelper;
import com.interview.demo.repository.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public final class CourseControllerGetTests {

    private static final String COURSE_ONE = "Math";

    private static final String COURSE_TWO = "Phyton programming language";

    private static final String COURSE_THREE = "Java programming language";

    @Autowired
    CourseRepository courseRepository;

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {
        courseRepository.deleteAll();
    }

    @Test
    public void returnAllCourses() {

        CourseTestHelper.buildAndSave(courseRepository, COURSE_ONE);
        CourseTestHelper.buildAndSave(courseRepository, COURSE_TWO);
        CourseTestHelper.buildAndSave(courseRepository, COURSE_THREE);

        var response = CourseTestHelper.getAllCoursesSuccessful(CourseTestHelper.getURL(port));
        assertThat(response.courses()).hasSize(3);

        assertThat(response.courses().get(0).name()).isEqualTo(COURSE_ONE);
        assertThat(response.courses().get(1).name()).isEqualTo(COURSE_TWO);

        assertThat(response.courses().get(2).name()).isEqualTo(COURSE_THREE);
    }

    @Test
    public void returnEmptyWhenThereIsNoCourseForProvidedName() {

        CourseTestHelper.buildAndSave(courseRepository, COURSE_ONE);
        CourseTestHelper.buildAndSave(courseRepository, COURSE_TWO);
        CourseTestHelper.buildAndSave(courseRepository, COURSE_THREE);

        var response = CourseTestHelper.getCoursesByNameSuccessful("German", CourseTestHelper.getURL(port));
        assertThat(response.courses().size()).isZero();
    }

    @Test
    public void returnOneCourseContainingProvidedName() {

        CourseTestHelper.buildAndSave(courseRepository, COURSE_ONE);
        CourseTestHelper.buildAndSave(courseRepository, COURSE_TWO);
        CourseTestHelper.buildAndSave(courseRepository, COURSE_THREE);

        var response = CourseTestHelper.getCoursesByNameSuccessful(COURSE_THREE, CourseTestHelper.getURL(port));
        assertThat(response.courses().size()).isOne();

        assertThat(response.courses().get(0).name()).isEqualTo(COURSE_THREE);

    }

    @Test
    public void returnTwoCourseContainingProvidedName() {

        CourseTestHelper.buildAndSave(courseRepository, COURSE_ONE);
        CourseTestHelper.buildAndSave(courseRepository, COURSE_TWO);
        CourseTestHelper.buildAndSave(courseRepository, COURSE_THREE);

        var response = CourseTestHelper.getCoursesByNameSuccessful("programming", CourseTestHelper.getURL(port));
        assertThat(response.courses()).hasSize(2);

        assertThat(response.courses().get(0).name()).isEqualTo(COURSE_TWO);
        assertThat(response.courses().get(1).name()).isEqualTo(COURSE_THREE);
    }

}
