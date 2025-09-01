package com.rinos.ecommerce.controller;

import com.rinos.ecommerce.dto.CreateOrderRequest;
import com.rinos.ecommerce.dto.OrderCreated;
import com.rinos.ecommerce.entity.Order;
import com.rinos.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderCreated> createOrder(@RequestBody CreateOrderRequest orderRequest) {
        OrderCreated orderCreated = orderService.createOrder(orderRequest);
        return ResponseEntity.ok().body(orderCreated);
    }

    @GetMapping("/{referenceId}")
    public ResponseEntity<Order> viewOrder(@PathVariable String referenceId) {
        Order order = orderService.getOrder(referenceId);
        return ResponseEntity.ok().body(order);
    }
}
