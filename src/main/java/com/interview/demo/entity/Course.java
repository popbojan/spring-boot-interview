package com.interview.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
public class Course extends AuditableEntity {

    @NotNull
    @Column(name = "name")
    @ToString.Exclude
    String name;
}
