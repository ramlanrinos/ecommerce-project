package com.rinos.ecommerce.dto;

import com.rinos.ecommerce.entity.ProductImage;
import com.rinos.ecommerce.entity.ProductReview;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;

public class ProductDto {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String category;
    private Double rating = 0.0;
    private String seller;
    private Integer stock = 0;
    private Integer nomOfReviews = 0;
    private List<ProductImage> images;
    private List<ProductReviewDto> reviews;

    public ProductDto() {
    }

    public ProductDto(Long id, String name, Double price, String description, String category, Double rating, String seller, Integer stock, Integer nomOfReviews) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.rating = rating;
        this.seller = seller;
        this.stock = stock;
        this.nomOfReviews = nomOfReviews;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getNomOfReviews() {
        return nomOfReviews;
    }

    public void setNomOfReviews(Integer nomOfReviews) {
        this.nomOfReviews = nomOfReviews;
    }

    public List<ProductReviewDto> getReviews() {
        return reviews;
    }

    public void setReviews(List<ProductReviewDto> reviews) {
        this.reviews = reviews;
    }
}
