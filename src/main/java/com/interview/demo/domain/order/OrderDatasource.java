package com.interview.demo.domain.order;

public interface OrderDatasource {

    Order getById(Long id);

    Order saveOrder(Order order);
}
