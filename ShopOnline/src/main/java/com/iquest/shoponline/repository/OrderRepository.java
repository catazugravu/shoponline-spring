package com.iquest.shoponline.repository;

import com.iquest.shoponline.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
