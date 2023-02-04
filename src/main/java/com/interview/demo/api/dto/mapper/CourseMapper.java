package com.interview.demo.api.dto.mapper;

import com.interview.demo.api.dto.CourseDTO;
import com.interview.demo.api.dto.CoursePageDTO;
import com.interview.demo.entity.Course;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CourseMapper {

    public static CoursePageDTO toPageDTO(List<Course> courses) {
        return CoursePageDTO.builder().courses(courses.stream().map(CourseMapper::toDTO).toList()).build();
    }

    public static CourseDTO toDTO(Course course) {
        return CourseDTO.builder().id(course.getId()).name(course.getName()).build();
    }
}
