package com.interview.demo.datasource;

import com.interview.demo.domain.order.Order;
import com.interview.demo.domain.order.OrderDatasource;
import com.interview.demo.datasource.mapper.OrderEntityMapper;
import com.interview.demo.datasource.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDatasourceImpl implements OrderDatasource {

    @Autowired
    OrderRepository repository;

    @Autowired
    OrderEntityMapper mapper;

    @Override
    public Order getById(Long id) {
        final var orderEntity = repository.findById(id);
        if (orderEntity.isPresent()) {
            return mapper.toModel(orderEntity.get());
        }
        throw new IllegalArgumentException("Order for the provided id is not found! Id: " + id);
    }

    @Override
    public Order saveOrder(Order order) {
        final var orderEntity = mapper.toEntity(order);
        final var persisted = repository.save(orderEntity);
        return mapper.toModel(persisted);
    }
}
