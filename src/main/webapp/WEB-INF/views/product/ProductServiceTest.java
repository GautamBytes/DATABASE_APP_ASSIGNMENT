package com.example.productmanagement.service;

import com.example.productmanagement.model.Category;
import com.example.productmanagement.model.Product;
import com.example.productmanagement.repository.CategoryRepository;
import com.example.productmanagement.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceTest {
    @MockBean
    private ProductRepository productRepository;
    
    @MockBean
    private CategoryRepository categoryRepository;
    
    @Autowired
    private ProductService productService;
    
    private Category category;
    private Product product;
    
    @BeforeEach
    public void setup() {
        category = new Category();
        category.setId(1L);
        category.setName("Test Category");
        
        product = new Product();
        product.setId(1L);
        product.setName("Test Product");
        product.setPrice(99.99);
        product.setCategory(category);
    }
    
    @Test
    public void testGetAllProducts() {
        // Given
        when(productRepository.findAll()).thenReturn(Arrays.asList(product));
        
        // When
        List<Product> products = productService.getAllProducts();
        
        // Then
        assertEquals(1, products.size());
        assertEquals("Test Product", products.get(0).getName());
    }
    
    @Test
    public void testGetProductById() {
        // Given
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        
        // When
        Product foundProduct = productService.getProductById(1L);
        
        // Then
        assertNotNull(foundProduct);
        assertEquals(1L, foundProduct.getId());
    }
    
    @Test
    public void testSaveProduct() {
        // Given
        when(productRepository.save(any(Product.class))).thenReturn(product);
        
        // When
        Product savedProduct = productService.saveProduct(product);
        
        // Then
        assertNotNull(savedProduct);
        assertEquals("Test Product", savedProduct.getName());
    }
}
