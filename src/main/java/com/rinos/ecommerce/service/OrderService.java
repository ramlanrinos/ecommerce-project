package com.rinos.ecommerce.service;

import com.rinos.ecommerce.dto.CreateOrderRequest;
import com.rinos.ecommerce.dto.OrderCreated;
import com.rinos.ecommerce.dto.OrderItemDto;
import com.rinos.ecommerce.entity.Order;
import com.rinos.ecommerce.entity.OrderItem;
import com.rinos.ecommerce.entity.Product;
import com.rinos.ecommerce.repository.OrderRepository;
import com.rinos.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    public OrderCreated createOrder(CreateOrderRequest orderRequest) {
        Order order = new Order();
        order.setStatus("PENDING");
        double totalItemsAmount = 0.0;

        for(OrderItemDto item : orderRequest.getOrderItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setName(item.getName());
            orderItem.setPrice(item.getPrice());
            orderItem.setImage(item.getImage());
            orderItem.setQuantity(item.getQuantity());

            Product product = productRepository.findById(item.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            orderItem.setProduct(product);
            totalItemsAmount += item.getPrice() * item.getQuantity();

            order.getOrderItems().add(orderItem);
        }

        order.setTotalItemsAmount(totalItemsAmount);
        double totalAmount = 0.0;
        double taxAmount = 10.0;
        totalAmount = totalItemsAmount + taxAmount;
        order.setTotalAmount(totalAmount);
        order.setTaxAmount(taxAmount);

        String refId = UUID.randomUUID().toString();
        order.setReferenceId(refId);

        orderRepository.save(order);

        return new OrderCreated(refId);
    }

    public Order getOrder(String referenceId) {
        return orderRepository.findByReferenceId(referenceId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
