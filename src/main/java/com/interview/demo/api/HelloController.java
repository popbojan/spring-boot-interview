package com.interview.demo.api;

import com.interview.demo.api.dto.HelloDTO;
import com.interview.demo.api.dto.mapper.HelloMapper;
import com.interview.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public ResponseEntity<HelloDTO> index(@RequestParam(required = false) String name) {

        return helloService.getHelloMessage(name)
                .map(hello -> new ResponseEntity<>(HelloMapper.toDTO(hello), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
