package com.example.mycartx.controller;

import com.example.mycartx.model.Cart;
import com.example.mycartx.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    private CartRepository cartRepo;

    // Add item to cart
    @PostMapping("/add")
    public String addToCart(@RequestBody Cart cart){
        cartRepo.save(cart);
        return "Item added to cart!";
    }

    // Get all items for a user
    @GetMapping("/{userId}")
    public List<Cart> getCart(@PathVariable Long userId){
        return cartRepo.findByUserId(userId);
    }

    // Remove item from cart
    @DeleteMapping("/remove/{id}")
    public String removeItem(@PathVariable Long id){
        cartRepo.deleteById(id);
        return "Item removed";
    }

    // Get ALL cart items (for testing/admin)
    @GetMapping("/all")
    public List<Cart> getAllCartItems() {
        return cartRepo.findAll();
    }
}