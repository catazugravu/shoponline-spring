package com.iquest.shoponline.repository;

import com.iquest.shoponline.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    Product findFirstById(Integer id);
}