package com.example.mycartx.service;

import com.example.mycartx.model.Product;
import com.example.mycartx.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product save(Product product) {
        return repository.save(product);
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public List<Product> getActiveProducts() {
        return repository.findByActiveTrue();
    }
}