package com.iquest.shoponline.services;

import com.iquest.shoponline.dto.product.ProductDto;
import com.iquest.shoponline.dto.product.ProductListDto;
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

    public List<ProductListDto> findAll() {
        Iterable<Product> products = productRepository.findAll();
        List<ProductListDto> dtos = new ArrayList<>();
        products.forEach(product -> populateDto(dtos, product));
        return dtos;
    }

    public List<ProductListDto> findProductsFromCategory(Integer categoryId) {
        List<Product> products = productRepository.findAllByCategoryId(categoryId);
        List<ProductListDto> dtos = new ArrayList<>();
        products.forEach(product -> populateDto(dtos, product));
        return dtos;
    }

    private void populateDto(List<ProductListDto> dtos, Product product) {
        ProductListDto dto = new ProductListDto();

        dto.setId(product.getId());
        dto.setCategoryId(product.getCategory().getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setImgPath1(product.getImgPath1());

        dtos.add(dto);
    }

    public ProductDto getProductById(Integer id) {
        Product product = productRepository.findFirstById(id);

        if (product != null) {
            ProductDto dto = new ProductDto();
            dto.setId(product.getId());
            dto.setName(product.getName());
            dto.setDescription(product.getDescription());
            dto.setPrice(product.getPrice());
            dto.setStock(product.getStock());
            dto.setImgPath1(product.getImgPath1());
            dto.setImgPath2(product.getImgPath2());

            return dto;
        }

        return null;
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Integer id) {
        productRepository.delete(id);
    }
}
