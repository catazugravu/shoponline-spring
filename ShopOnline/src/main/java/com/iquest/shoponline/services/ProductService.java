package com.iquest.shoponline.services;

import com.iquest.shoponline.dto.product.ProductDtoList;
import com.iquest.shoponline.model.Product;
import com.iquest.shoponline.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<ProductDtoList> findAll() {
        Iterable<Product> products = productRepository.findAll();
        List<ProductDtoList> dtos = new ArrayList<>();
        products.forEach(product -> populateDto(dtos, product));
        return dtos;
    }

    private void populateDto(List<ProductDtoList> dtos, Product product) {
        ProductDtoList dto = new ProductDtoList();
        dto.setId(product.getId());
        dto.setCategoryId(product.getCategory().getName());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getStock());
        dto.setImgPath1(product.getImgPath1());
        dto.setImgPath2(product.getImgPath2());

        dtos.add(dto);
    }
}
