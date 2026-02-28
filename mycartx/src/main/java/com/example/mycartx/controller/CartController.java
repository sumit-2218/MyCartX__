package com.example.mycartx.controller;

import com.example.mycartx.model.Cart;
import com.example.mycartx.service.CartService;
import org.springframework.web.bind.annotation.*;
import com.example.mycartx.dto.CartResponse;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin("*")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // Add to cart
    @PostMapping("/add")
    public Cart addToCart(@RequestParam Long userId,
                          @RequestParam Long productId) {

        return cartService.addToCart(userId, productId);
    }

    // Get user cart
    @GetMapping("/{userId}")
    public List<CartResponse> getCart(@PathVariable Long userId) {
        return cartService.getUserCart(userId);
    }
}