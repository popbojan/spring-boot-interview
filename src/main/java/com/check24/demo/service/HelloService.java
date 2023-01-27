package com.check24.demo.service;

import com.check24.demo.entity.Hello;

import java.util.Optional;

public interface HelloService {

    Optional<Hello> getHelloMessage(String name);
}
