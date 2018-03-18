package com.iquest.shoponline.repository;

import com.iquest.shoponline.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query("SELECT p.name FROM Product p where p.id = :id")
    String findNameById(@Param("id") Integer id);

    @Query("SELECT p.price FROM Product p where p.id = :id")
    Double findPriceById(@Param("id") Integer id);
}