package com.interview.demo.api.dto;

import com.interview.demo.domain.order.OrderStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderDto {

    Long id;

    String orderNumber;

    String customerEmail;

    OrderStatus orderStatus;

    BigDecimal totalAmount;

    LocalDateTime createdAt;
}
