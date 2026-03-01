package com.interview.demo.api;

import com.interview.demo.api.dto.OrderDto;
import com.interview.demo.api.dto.PageDto;
import com.interview.demo.api.dto.mapper.OrderMapper;
import com.interview.demo.domain.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    OrderMapper mapper;

    @Autowired
    OrderService orderService;

    @GetMapping("/id")
    public ResponseEntity<OrderDto> getById(@PathVariable(name = "id") Long id){
        final var dto = mapper.toDto(orderService.getById(id));
        return ResponseEntity
                .status(HttpStatusCode.valueOf(200))
                .body(dto);
    }

    @GetMapping
    public ResponseEntity<PageDto<OrderDto>> getAll(Pageable pageable){
        final var page = orderService.getAll(pageable);
        final var pageDto = mapper.toDto(page);
        return ResponseEntity.ok(PageDto.from(pageDto));
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody OrderDto orderDto){
        final var id = orderService.saveOrder(mapper.toModel(orderDto));

        URI location = URI.create("/api/orders/" + id);

        return ResponseEntity
                .created(location)
                .build();
    }
}