package com.interview.demo.api;

import com.interview.demo.api.dto.CoursePageDTO;
import com.interview.demo.api.dto.mapper.CourseMapper;
import com.interview.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping
    public ResponseEntity<CoursePageDTO> getAllCourses() {
        var courses = courseService.getAllCourses();
        return new ResponseEntity<>(CourseMapper.toPageDTO(courses), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<CoursePageDTO> getCourseByName(@PathVariable(name = "name") String name) {
        var courses = courseService.findByName(name);
        return new ResponseEntity<>(CourseMapper.toPageDTO(courses), HttpStatus.OK);
    }

    @PutMapping("/{courseId}/student/{studentId}/grade/{grade}")
    public ResponseEntity updateGrade(
            @PathVariable(name = "courseId") Long courseId,
            @PathVariable(name = "studentId") Long studentId,
            @PathVariable int grade) {
        courseService.gradeStudent(courseId, studentId, grade);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
