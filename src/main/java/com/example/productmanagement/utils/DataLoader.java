package com.example.productmanagement.utils;

import com.example.productmanagement.model.Category;
import com.example.productmanagement.model.Product;
import com.example.productmanagement.repository.CategoryRepository;
import com.example.productmanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // Check if data already exists
        if (categoryRepository.count() == 0) {
            loadData();
        }
    }
    
    private void loadData() {
        // Create categories (at least 10)
        Category electronics = new Category("Electronics", "Electronic devices and accessories");
        Category clothing = new Category("Clothing", "Apparel and fashion items");
        Category books = new Category("Books", "Books and publications");
        Category groceries = new Category("Groceries", "Food and household items");
        Category toys = new Category("Toys", "Children's toys and games");
        Category furniture = new Category("Furniture", "Home and office furniture");
        Category sports = new Category("Sports", "Sports equipment and gear");
        Category beauty = new Category("Beauty", "Beauty and personal care products");
        Category automotive = new Category("Automotive", "Car parts and accessories");
        Category jewelry = new Category("Jewelry", "Jewelry and watches");
        
        categoryRepository.save(electronics);
        categoryRepository.save(clothing);
        categoryRepository.save(books);
        categoryRepository.save(groceries);
        categoryRepository.save(toys);
        categoryRepository.save(furniture);
        categoryRepository.save(sports);
        categoryRepository.save(beauty);
        categoryRepository.save(automotive);
        categoryRepository.save(jewelry);
        
        // Create products (at least 10)
        // Electronics
        productRepository.save(new Product("Laptop", "15-inch laptop with 16GB RAM", 999.99, electronics));
        productRepository.save(new Product("Smartphone", "Latest model with 128GB storage", 699.99, electronics));
        
        // Clothing
        productRepository.save(new Product("T-Shirt", "Cotton t-shirt, various colors", 19.99, clothing));
        productRepository.save(new Product("Jeans", "Classic blue jeans", 39.99, clothing));
        
        // Books
        productRepository.save(new Product("Novel", "Bestselling fiction novel", 14.99, books));
        productRepository.save(new Product("Cookbook", "Recipes from around the world", 24.99, books));
        
        // Groceries
        productRepository.save(new Product("Coffee", "Premium ground coffee", 9.99, groceries));
        productRepository.save(new Product("Pasta", "Italian pasta, 500g", 2.99, groceries));
        
        // Toys
        productRepository.save(new Product("Action Figure", "Collectible action figure", 12.99, toys));
        productRepository.save(new Product("Board Game", "Family board game", 29.99, toys));
    }
}
