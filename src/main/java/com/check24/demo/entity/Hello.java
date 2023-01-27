package com.check24.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "hello")
@Data
public class Hello {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

}
