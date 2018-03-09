package com.iquest.shoponline.repository;

import com.iquest.shoponline.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

    @Query("select count(id) from Product p where p.category.id = ?1")
    int countProductsInCategory(Integer categoryId);
}
