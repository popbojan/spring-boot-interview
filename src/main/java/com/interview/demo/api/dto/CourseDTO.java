package com.interview.demo.api.dto;

import lombok.Builder;

@Builder
public record CourseDTO(Long id, String name) {

}
