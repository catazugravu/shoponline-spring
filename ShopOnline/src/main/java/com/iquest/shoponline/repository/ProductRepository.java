package com.iquest.shoponline.repository;

import com.iquest.shoponline.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    Product findFirstById(Integer id);

    List<Product> findAllByCategoryId(Integer id);
}