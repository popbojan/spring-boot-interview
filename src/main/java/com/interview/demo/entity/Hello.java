package com.interview.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
public class Hello extends AuditableEntity {

    @Column(name = "name")
    private String name;

}
