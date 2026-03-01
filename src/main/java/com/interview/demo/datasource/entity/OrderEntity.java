package com.interview.demo.datasource.entity;


import com.interview.demo.domain.order.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class OrderEntity {

    @Id
    @GeneratedValue
    Long id;

    String orderNumber;

    String customerEmail;

    @Enumerated(EnumType.STRING)
    OrderStatus orderStatus;

    BigDecimal totalAmount;

    LocalDateTime createdAt;

    @Version
    Integer version;

}
