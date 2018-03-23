package com.iquest.shoponline.controller;

import com.iquest.shoponline.constants.Views;
import com.iquest.shoponline.dto.product.ProductDto;
import com.iquest.shoponline.model.Product;
import com.iquest.shoponline.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public String getProductList(Model model) {
        model.addAttribute("products", productService.findAll());
        return Views.PRODUCT_PAGE;
    }

    @GetMapping("/{id}")
    public String getProduct(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return Views.PRODUCT_INFO_PAGE;
    }

    //TODO: JSP for add/update product
    @PostMapping("/{id}")
    public String updateProduct(@PathVariable("id") Integer id, Model model, @ModelAttribute("product") Product product) {
        model.addAttribute("product", productService.updateProduct(product));
        return Views.PRODUCT_INFO_PAGE;
    }

    //TODO: JSP for delete product
    @DeleteMapping("/{id}")
    public String getProduct(@PathVariable("id") Integer id) {
        productService.deleteProduct(id);
        return "redirect:product/";
    }

}