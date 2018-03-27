package com.iquest.shoponline.dto.cart;

import com.iquest.shoponline.dto.cartItem.CartItemDto;
import com.iquest.shoponline.model.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartDto {

    private Integer id;
    private List<CartItemDto> items;

    public CartDto() {
        items = new ArrayList<>();
    }

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

    public void addItem(CartItemDto item) {
        if (items == null) {
            items = new ArrayList<>();
        }
        items.add(item);
    }
}
