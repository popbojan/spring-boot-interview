package com.interview.demo.domain.order.service;

import com.interview.demo.domain.order.Order;
import com.interview.demo.domain.order.OrderDatasource;
import com.interview.demo.domain.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDatasource datasource;

    @Override
    public Order getById(Long id) {
        return datasource.getById(id);
    }

    @Override
    public Long saveOrder(Order order) {
        final var saved = datasource.saveOrder(order);
        return saved.id();

    }

    @Override
    public Page<Order> getAll(Pageable pageable) {
        return datasource.getAll(pageable);
    }
}
