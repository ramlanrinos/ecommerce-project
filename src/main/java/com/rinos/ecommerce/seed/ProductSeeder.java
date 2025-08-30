package com.rinos.ecommerce.seed;

import com.rinos.ecommerce.entity.Product;
import com.rinos.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductSeeder implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

//    It runs when the app starts up
//    It checks if there are any products in the database
//    If the database is empty, it creates 11 demo products (like iPhones, laptops, headphones)
//    If products already exist, it does nothing
//    It prints a message saying whether it added products or skipped
    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0) {
            List<Product> demoProducts = List.of(
                    new Product(null, "Apple iPhone 15", 799.0, "SmartPhone with a16 Chip", "Phones", 4.8, "Amazon", 5),
                    new Product(null, "Samsung Galaxy S23", 849.99, "SmartPhone with Snapdragon 8 Gen 2", "Phones", 4.7, "Best Buy", 3),
                    new Product(null, "Sony WH-1000XM5", 399.99, "Wireless Noise-Canceling Headphones", "Headphones", 4.9, "Amazon", 7),
                    new Product(null, "Dell XPS 13", 1299.00, "Laptop with 13.4-inch OLED Display", "Laptop", 4.6, "Dell", 2),
                    new Product(null, "Apple AirPods Pro 2", 249.00, "Wireless Earbuds with Active Noise Cancellation", "Headphones", 4.8, "Apple Store", 10),
                    new Product(null, "Nintendo Switch OLED", 349.99, "Gaming Console with 7-inch OLED Screen", "Laptop", 4.5, "GameStop", 4),
                    new Product(null, "Canon EOS R6", 2299.00, "Mirrorless Camera with 20MP Sensor", "Camera", 4.7, "Phones", 1),
                    new Product(null, "Samsung QN90B", 1499.99, "55-inch 4K QLED Smart TV", "Laptop", 4.6, "Walmart", 3),
                    new Product(null, "Fitbit Charge 6", 159.95, "Fitness Tracker with Heart Rate Monitoring", "Headphones", 4.4, "Amazon", 8),
                    new Product(null, "Dyson V15 Detect", 699.99, "Cordless Vacuum with Laser Dust Detection", "Phones", 4.8, "Dyson", 2),
                    new Product(null, "Microsoft Surface Pro 9", 1099.99, "Tablet with Intel Core i5 and 256GB SSD", "Laptop", 4.5, "Microsoft Store", 5)
            );
            productRepository.saveAll(demoProducts);
            System.out.println("Seeded demo products");
        } else {
            System.out.println("Products already exists, skipping seed");
        }
    }
}
