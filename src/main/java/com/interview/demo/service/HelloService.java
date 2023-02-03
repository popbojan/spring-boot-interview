package com.interview.demo.service;

import com.interview.demo.entity.Hello;

import java.util.Optional;

public interface HelloService {

    Optional<Hello> getHelloMessage(String name);
}
