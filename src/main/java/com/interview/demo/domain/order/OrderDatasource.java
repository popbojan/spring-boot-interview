package com.interview.demo.domain.order;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderDatasource {

    Order getById(Long id);

    Order saveOrder(Order order);

    Page<Order> getAll(Pageable pageable);
}
