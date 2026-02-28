package com.example.mycartx.dto;

public class CartResponse {

    private Long cartId;
    private Long productId;
    private String name;
    private Double price;
    private String imageUrl;
    private Integer quantity;

    public CartResponse(Long cartId, Long productId, String name,
                        Double price, String imageUrl, Integer quantity) {
        this.cartId = cartId;
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.quantity = quantity;
    }

    public Long getCartId() { return cartId; }
    public Long getProductId() { return productId; }
    public String getName() { return name; }
    public Double getPrice() { return price; }
    public String getImageUrl() { return imageUrl; }
    public Integer getQuantity() { return quantity; }
}