package com.interview.demo.domain.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Order(Long id, String orderNumber, String customerEmail, OrderStatus orderStatus, BigDecimal totalAmount, LocalDateTime createdAt) {}
