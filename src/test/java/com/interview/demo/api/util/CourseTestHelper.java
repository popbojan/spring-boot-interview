package com.interview.demo.api.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.interview.demo.api.dto.CoursePageDTO;
import com.interview.demo.entity.Course;
import com.interview.demo.repository.CourseRepository;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static io.restassured.RestAssured.given;

public final class CourseTestHelper {

    public static Course buildAndSave(final CourseRepository courseRepository, final String name) {
        var course = new Course();
        course.setName(name);
        courseRepository.saveAndFlush(course);
        return course;
    }

    private static final String COURSE_BY_NAME_PATH = "/api/course/name/{name}";

    private static final String ALL_COURSES_PATH = "/api/course";

    private static final String GRADE_STUDENT_PATH = "/api/course/{courseId}/student/{studentId}/grade/{grade}";

    public static CoursePageDTO getAllCoursesSuccessful(final String url) {
        return getAllCourses(url, HttpStatus.SC_OK).as(new TypeReference<CoursePageDTO>() {}.getType());
    }

    private static ExtractableResponse<Response> getAllCourses(final String url, final int status) {
        return given().when().get(url + ALL_COURSES_PATH).then().statusCode(status).extract();
    }

    public static CoursePageDTO getCoursesByNameSuccessful(final String name, final String url) {
        return getCoursesByName(name, url, HttpStatus.SC_OK).as(new TypeReference<CoursePageDTO>() {}.getType());
    }

    private static ExtractableResponse<Response> getCoursesByName(final String name, final String url, final int status) {
        final var requestSpecification = given().when();
        Optional.ofNullable(name).ifPresent(param -> requestSpecification.pathParam("name", param));
        return requestSpecification.get(url + COURSE_BY_NAME_PATH).then().statusCode(status).extract();
    }


    public static ResponseEntity gradeStudentSuccessful(final Long courseId, final Long studentId, final Integer grade, final String url) {
        final var requestSpecification = given().when();
        Optional.ofNullable(courseId).ifPresent(param -> requestSpecification.pathParam("courseId", param));
        Optional.ofNullable(studentId).ifPresent(param -> requestSpecification.pathParam("studentId", param));
        Optional.ofNullable(grade).ifPresent(param -> requestSpecification.pathParam("grade", param));
        return given().contentType(ContentType.JSON)
                .when()
                .put(url + GRADE_STUDENT_PATH)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(new TypeReference<ResponseEntity>() {}.getType());
    }

    public static String getURL(final int port) {
        return String.format("http://localhost:%s", port);
    }
}
