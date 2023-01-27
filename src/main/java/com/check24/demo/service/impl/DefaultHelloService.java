package com.check24.demo.service.impl;

import com.check24.demo.entity.Hello;
import com.check24.demo.repository.HelloRepository;
import com.check24.demo.service.HelloService;
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
