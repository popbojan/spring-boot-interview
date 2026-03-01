package com.interview.demo.domain.order;

public interface OrderService {
    Order getById(Long id);

    Long saveOrder(Order order);
}
