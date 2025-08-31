package com.rinos.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)   // we should have name field for a product
    @NotBlank(message = "Name field is required")   // to show error if we don't give a name
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Price field is required")
    @PositiveOrZero(message = "Value must be zero or greater than zero")    // to avoid negative values for price
    private Double price;

    private String description;

    private String category;

    private Double rating = 0.0;

    @NotBlank(message = "Seller field is required")
    private String seller;

    @NotNull(message = "Stock field is required")
    private Integer stock = 0;

    private Integer nomOfReviews = 0;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)  // for make a relationship, if any changes happen in the products it reflects in the child table also
    @JoinColumn(name = "product_id")    // to set foreign key name
    private List<ProductImage> images;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private List<ProductReview> reviews;

    public Product() {}

    public Product(Long id, String name, Double price, String description, Double rating, String seller, Integer stock, Integer nomOfReviews) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.rating = rating;
        this.seller = seller;
        this.stock = stock;
        this.nomOfReviews = nomOfReviews;
    }

    public Product(Long id, String name, Double price, String description, String category, Double rating, String seller, Integer stock, List<String> images) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.rating = rating;
        this.seller = seller;
        this.stock = stock;
        this.images = images.stream()
                .map(url -> new ProductImage(url, this)).collect(Collectors.toList());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<ProductReview> getReviews() {
        return reviews;
    }

    public void setReviews(List<ProductReview> reviews) {
        this.reviews = reviews;
    }

    public List<ProductImage> getImages() {
        return images;
    }

    public void setImages(List<ProductImage> images) {
        this.images = images;
    }
}
