package com.iquest.shoponline.repository;

import com.iquest.shoponline.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Integer> {
}
