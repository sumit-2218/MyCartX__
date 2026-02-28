package com.example.mycartx.controller;

import com.example.mycartx.model.Product;
import com.example.mycartx.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService service;

    // ADMIN: add product to inventory
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return service.save(product);
    }

    // ADMIN: view all products
    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAll();
    }

    // USER: show only active products
    @GetMapping("/active")
    public List<Product> getActiveProducts() {
        return service.getActiveProducts();
    }
}