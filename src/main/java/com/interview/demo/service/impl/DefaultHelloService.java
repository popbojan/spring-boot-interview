package com.interview.demo.service.impl;

import com.interview.demo.service.HelloService;
import com.interview.demo.datasource.entity.Hello;
import com.interview.demo.datasource.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultHelloService implements HelloService {

    @Autowired
    HelloRepository helloRepository;
    @Override
    public Optional<Hello> getHelloMessage(String name) {
        return helloRepository.findByName(name);
    }
}
