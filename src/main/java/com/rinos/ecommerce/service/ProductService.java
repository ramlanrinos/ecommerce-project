package com.rinos.ecommerce.service;

import com.rinos.ecommerce.entity.Product;
import com.rinos.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Map<String, Object> getAllProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
//        This Page object is powerful because it contains the requested data plus information about the entire dataset.
        Page<Product> products = productRepository.findAll(pageable);   // it will return Page type, generics is Product
        Map<String, Object> response = new HashMap<>();
        response.put("totalProducts", products.getTotalElements()); // return no. of all products, this is for frontend work
        response.put("currentPage", products.getNumber()); // The current page number
        response.put("totalPages", products.getTotalPages()); // The total number of pages
        response.put("hasNext", products.hasNext()); // true/false if there's a next page
        response.put("hasPrevious", products.hasPrevious()); // true/false if there's a previous page
        response.put("products", products.getContent());    // return no. of products within a page
        return response;
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with the id: " + id));
    }
}
