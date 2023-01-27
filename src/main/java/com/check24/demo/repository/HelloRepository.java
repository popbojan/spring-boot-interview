package com.check24.demo.repository;

import com.check24.demo.entity.Hello;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HelloRepository extends JpaRepository<Hello, Long> {

    Optional<Hello> findByName(String name);

}
