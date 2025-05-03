package com.example.productmanagement.repository;

import com.example.productmanagement.model.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Test
    public void testSaveCategory() {
        // Given
        Category category = new Category();
        category.setName("Test Category");
        category.setDescription("Test Description");
        
        // When
        Category savedCategory = categoryRepository.save(category);
        
        // Then
        assertNotNull(savedCategory.getId());
        assertEquals("Test Category", savedCategory.getName());
    }
    
    @Test
    public void testFindById() {
        // Given
        Category category = new Category();
        category.setName("Test Category");
        category.setDescription("Test Description");
        Category savedCategory = categoryRepository.save(category);
        
        // When
        Category foundCategory = categoryRepository.findById(savedCategory.getId()).orElse(null);
        
        // Then
        assertNotNull(foundCategory);
        assertEquals(savedCategory.getId(), foundCategory.getId());
    }
}