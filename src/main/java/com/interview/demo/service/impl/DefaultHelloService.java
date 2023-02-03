package com.interview.demo.service.impl;

import com.interview.demo.entity.Hello;
import com.interview.demo.repository.HelloRepository;
import com.interview.demo.service.HelloService;
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
