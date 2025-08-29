package com.rinos.ecommerce.controller;

import com.rinos.ecommerce.entity.Product;
import com.rinos.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public Map<String, Object> getAllProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
//        List<Product> products = productService.getAllProducts(page, size);
//        return ResponseEntity.ok(products);   // to return products as JSON response
        return productService.getAllProducts(page, size);
    }
}
