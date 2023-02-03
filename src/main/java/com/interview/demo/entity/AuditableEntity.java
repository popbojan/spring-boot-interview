package com.interview.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@MappedSuperclass
@ToString
public abstract class AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updated;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime created;

}
