package com.iquest.shoponline.dto.cart;

import com.iquest.shoponline.dto.cartItem.CartItemDto;

import java.util.List;

public class CartDto {

    private Integer id;
    private List<CartItemDto> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CartItemDto> getItems() {
        return items;
    }

    public void setItems(List<CartItemDto> items) {
        this.items = items;
    }
}
