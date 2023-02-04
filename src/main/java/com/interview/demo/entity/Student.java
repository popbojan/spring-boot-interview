package com.interview.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
public class Student extends AuditableEntity {

    @NotNull
    @Column(name = "firstname")
    @ToString.Exclude
    String firstname;

    @NotNull
    @Column(name = "lastname")
    @ToString.Exclude
    String lastname;
}
