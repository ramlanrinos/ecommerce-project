package com.rinos.ecommerce.controller;

import com.rinos.ecommerce.dto.ProductReviewDto;
import com.rinos.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products/reviews")
public class ProductReviewController {
    @Autowired
    private ProductService productService;

    @PostMapping
    // We don't use entity class for RequestBody. Therefor, use ProductReviewDto (Data Transfer Object)
    // @RequestBody is a crucial annotation. It tells Spring to take the JSON data from the HTTP request body
    // and automatically convert (deserialize) it into a ProductReviewDto Java object.
    public ResponseEntity<String> addReview(@RequestBody @Valid ProductReviewDto reviewDto) {
        productService.addReview(reviewDto);
        // ResponseEntity.status(HttpStatus.CREATED): This sets the HTTP Status Code to 201 CREATED. This is the semantically correct status code for a successful
        // request that resulted in a new resource (the review) being created. It's more specific than the generic 200 OK.
        // .body("Review added"): This sets the response body to a simple success message string.
        return ResponseEntity.status(HttpStatus.CREATED).body("Review added");
    }
}
