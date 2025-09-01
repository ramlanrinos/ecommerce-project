package com.rinos.ecommerce.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

    private Double totalItemsAmount;
    private Double taxAmount;
    private Double totalAmount;
    private String status;
    private String referenceId;

    public Order() {
    }

    public Order(List<OrderItem> orderItems, Double totalItemsAmount, Double taxAmount, Double totalAmount, String status, String referenceId) {
        this.orderItems = orderItems;
        this.totalItemsAmount = totalItemsAmount;
        this.taxAmount = taxAmount;
        this.totalAmount = totalAmount;
        this.status = status;
        this.referenceId = referenceId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItem) {
        this.orderItems = orderItem;
    }

    public Double getTotalItemsAmount() {
        return totalItemsAmount;
    }

    public void setTotalItemsAmount(Double totalItemsAmount) {
        this.totalItemsAmount = totalItemsAmount;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String orderNo) {
        this.referenceId = orderNo;
    }
}
