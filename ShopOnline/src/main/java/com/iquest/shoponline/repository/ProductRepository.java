package com.iquest.shoponline.repository;

import com.iquest.shoponline.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query("SELECT p.name FROM Product p where p.id = :id")
    String findNameById(@Param("id") Integer id);

    Product findFirstById(Integer id);

    List<Product> findAllByCategoryId(Integer id);
}