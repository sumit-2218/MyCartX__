package com.example.mycartx.service;

import com.example.mycartx.model.Cart;
import com.example.mycartx.repository.CartRepository;
import com.example.mycartx.dto.CartResponse;
import com.example.mycartx.model.Product;
import com.example.mycartx.repository.ProductRepository;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public Cart addToCart(Long userId, Long productId) {

        // check if already exists
        Cart cart = cartRepository
                .findByUserIdAndProductId(userId, productId)
                .orElse(null);

        if (cart != null) {
            cart.setQuantity(cart.getQuantity() + 1);
        } else {
            cart = new Cart(userId, productId, 1);
        }

        return cartRepository.save(cart);
    }

    public List<CartResponse> getUserCart(Long userId) {

        List<Cart> cartItems = cartRepository.findByUserId(userId);
        List<CartResponse> responseList = new ArrayList<>();

        for (Cart cart : cartItems) {

            Product product = productRepository.findById(cart.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            CartResponse response = new CartResponse(
                    cart.getId(),
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getImageUrl(),
                    cart.getQuantity()
            );

            responseList.add(response);
        }

        return responseList;
    }
}