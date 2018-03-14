package com.iquest.shoponline.repository;

import com.iquest.shoponline.model.CartItem;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItem, Integer> {
}
