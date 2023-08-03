package com.fruitweb.dto;

import com.fruitweb.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CartItemDto {

    private  int quantity;
    private Product product;


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public CartItemDto(Product product,int quantity) {
        this.quantity = quantity;
        this.product = product;
    }

    public CartItemDto() {
        super();
    }

    public double getAmount() {
        return this.product.getCostPrice() * this.quantity;
    }

    @Override
    public String toString() {
        return "CartItemDto{" +
                "quantity=" + quantity +
                ", product=" + product +
                '}';
    }
}
