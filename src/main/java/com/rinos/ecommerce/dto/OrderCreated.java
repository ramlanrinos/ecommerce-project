package com.rinos.ecommerce.dto;

public class OrderCreated {
    private String referenceId;

    public OrderCreated(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }
}
