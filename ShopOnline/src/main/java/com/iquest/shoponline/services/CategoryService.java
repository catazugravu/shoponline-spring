package com.iquest.shoponline.services;

import com.iquest.shoponline.dto.category.CategoryDto;
import com.iquest.shoponline.model.Category;
import com.iquest.shoponline.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository repository;

    public List<CategoryDto> findAll() {
        Iterable<Category> categories = repository.findAll();
        List<CategoryDto> dtos = new ArrayList<>();
        categories.forEach(category -> populateDto(dtos, category));
        return dtos;
    }

    private void populateDto(List<CategoryDto> dtos, Category category) {
        CategoryDto dto = new CategoryDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setProductCount(repository.countProductsInCategory(category.getId()));
        dtos.add(dto);
    }

    public String getCategoryName(Integer id) {
        return repository.findFirstById(id).getName().toUpperCase();
    }
}
