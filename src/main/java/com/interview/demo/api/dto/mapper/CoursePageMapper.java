package com.interview.demo.api.dto.mapper;

import com.interview.demo.api.dto.CourseDTO;
import com.interview.demo.api.dto.CoursePageDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CoursePageMapper {

        public static CoursePageDTO toDTO(List<CourseDTO> courses){
            return CoursePageDTO.builder().courses(courses).build();
        }

}
