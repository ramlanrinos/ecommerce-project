package com.rinos.ecommerce.spec;

import com.rinos.ecommerce.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

//    This method is a building block for a search/filter feature. Imagine a product list page with a "Filter by
//    Category" dropdown. When a user selects a category like "Electronics", this method helps build the query
//    WHERE category = 'Electronics'.
    public static Specification<Product> hasCategory(String category) {
//        root: Represents the Product entity itself. You use it to access its fields (like category).
//        cb (CriteriaBuilder): A toolkit for building conditions (like =, >, LIKE).
//        query: The blueprint for the overall SELECT statement. Used to modify the query's structure: distinct, groupBy, multiselect.
        return (root, query, cb) -> category == null ? null : cb.equal(root.get("category"), category);
//        IF the provided category is null (meaning the user didn't select any filter),
//        THEN return null (which means "apply no filtering rule").
//        OTHERWISE, create a rule using cb.equal that checks if the product's category field equals the provided category string.
    }

    public static Specification<Product> priceBetween(Double min, Double max) {
        return (root, query, cb) -> {
            if (min == null && max == null) return null;
            if (min == null && max != null) return cb.lessThanOrEqualTo(root.get("price"), max);
            if (min != null && max == null) return cb.greaterThanOrEqualTo(root.get("price"), min);
            return cb.between(root.get("price"), min, max);
        };
    }

    public static Specification<Product> hasNameOrDescriptionLike(String keyword) {
        return (root, query, cb) -> {
            if (keyword == null || keyword.isEmpty()) return null;
            // cb.or(...): Combines conditions so a product matches if any of them are true.
            // cb.like(...): Creates a pattern-matching condition for a database field.
            return cb.or(
                    cb.like(root.get("name"), "%" + keyword.toLowerCase() + "%"),
                    cb.like(root.get("description"), "%" + keyword.toLowerCase() + "%")
            );
        };
    }
}
