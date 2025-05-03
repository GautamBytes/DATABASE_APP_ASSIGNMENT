package com.example.productmanagement.controller;

import com.example.productmanagement.model.Product;
import com.example.productmanagement.service.CategoryService;
import com.example.productmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product/list";
    }
    
    @GetMapping("/new")
    public String showNewProductForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "product/form";
    }
    
    @PostMapping
    public String saveProduct(@ModelAttribute("product") Product product) {
        try {
            productService.saveProduct(product);
            return "redirect:/products";
        } catch (Exception e) {
            // Handle exception
            return "product/form";
        }
    }
    
    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("categories", categoryService.getAllCategories());
        return "product/form";
    }
    
    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute("product") Product product) {
        productService.updateProduct(id, product);
        return "redirect:/products";
    }
    
    @GetMapping("/by-category")
    public String listProductsByCategory(@RequestParam("categoryName") String categoryName, Model model) {
        model.addAttribute("products", productService.getProductsByCategoryName(categoryName));
        model.addAttribute("categoryName", categoryName);
        return "product/by-category";
    }
}
