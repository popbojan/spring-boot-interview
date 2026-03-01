package com.interview.demo.datasource.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
@Data
@Entity
public class Hello extends AuditableEntity {

    @Column(name = "name")
    private String name;

}
