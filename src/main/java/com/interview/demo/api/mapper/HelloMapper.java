package com.interview.demo.api.mapper;

import com.interview.demo.api.dto.HelloDTO;
import com.interview.demo.entity.Hello;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HelloMapper {

    public static HelloDTO toDTO(Hello entity){
        return HelloDTO.builder().name(entity.getName()).build();
    }
}
