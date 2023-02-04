package com.interview.demo.api.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record CoursePageDTO(List<CourseDTO> courses) {}
