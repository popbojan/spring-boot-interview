package com.interview.demo.datasource.mapper;

import com.interview.demo.domain.order.Order;
import com.interview.demo.datasource.entity.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderEntityMapper {

    public OrderEntity toEntity(Order model) {
        final var entity = new OrderEntity();
        entity.setId(model.id());
        entity.setOrderNumber(model.orderNumber());
        entity.setCustomerEmail(model.customerEmail());
        entity.setOrderStatus(model.orderStatus());
        entity.setTotalAmount(model.totalAmount());
        entity.setCreatedAt(model.createdAt());
        return entity;
    }

    public Order toModel(OrderEntity entity) {
        final var order = new Order(entity.getId(), entity.getOrderNumber(), entity.getCustomerEmail(), entity.getOrderStatus(),
                entity.getTotalAmount(), entity.getCreatedAt());
        return order;
    }
}
