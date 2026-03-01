package com.interview.demo.domain.order;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    Order getById(Long id);

    Long saveOrder(Order order);

    Page<Order> getAll(Pageable pageable);
}
