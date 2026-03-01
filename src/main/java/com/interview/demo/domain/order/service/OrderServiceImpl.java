package com.interview.demo.domain.order.service;

import com.interview.demo.domain.order.Order;
import com.interview.demo.domain.order.OrderDatasource;
import com.interview.demo.domain.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDatasource orderDatasource;

    @Override
    public Order getById(Long id) {
        return orderDatasource.getById(id);
    }

    @Override
    public Long saveOrder(Order order) {
        final var saved = orderDatasource.saveOrder(order);
        return saved.id();

    }
}
