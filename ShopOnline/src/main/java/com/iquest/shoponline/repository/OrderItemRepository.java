package com.iquest.shoponline.repository;

import com.iquest.shoponline.model.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {
}
