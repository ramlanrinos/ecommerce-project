package com.rinos.ecommerce.repository;

import com.rinos.ecommerce.entity.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {

}
