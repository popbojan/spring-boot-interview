package com.interview.demo.api.dto.mapper;

import com.interview.demo.domain.order.Order;
import com.interview.demo.api.dto.OrderDto;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {


    public Order toModel(OrderDto dto) {
        final var order = new Order(dto.getId(), dto.getOrderNumber(), dto.getCustomerEmail(), dto.getOrderStatus(), dto.getTotalAmount(),
                dto.getCreatedAt());
        return order;
    }

    public OrderDto toDto(Order order){
        final var orderDTO = new OrderDto();
        orderDTO.setId(order.id());
        orderDTO.setOrderNumber(order.orderNumber());
        orderDTO.setCustomerEmail(order.customerEmail());
        orderDTO.setOrderStatus(order.orderStatus());
        orderDTO.setTotalAmount(order.totalAmount());
        orderDTO.setCreatedAt(order.createdAt());
        return orderDTO;
    }
}
