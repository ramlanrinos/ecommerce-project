package com.rinos.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class ProductReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1) // to set min value
    @Max(value = 5) // to set max value
    private Double rating;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "product_id")
    // @JsonIgnore // it prevents take the product data in the response time
    private Product product;

    public ProductReview() {}

    public ProductReview(Long id, Double rating, String comment) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Min(value = 1) @Max(value = 5) Double getRating() {
        return rating;
    }

    public void setRating(@Min(value = 1) @Max(value = 5) Double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
