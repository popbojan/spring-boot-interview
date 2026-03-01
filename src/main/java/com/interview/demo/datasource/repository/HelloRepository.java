package com.interview.demo.datasource.repository;

import com.interview.demo.datasource.entity.Hello;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HelloRepository extends JpaRepository<Hello, Long> {

    Optional<Hello> findByName(String name);

}
