package com.iquest.shoponline.controller;

import com.iquest.shoponline.constants.Views;
import com.iquest.shoponline.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String getProductList(Model model) {
        model.addAttribute("products", productService.findAll());
        return Views.PRODUCT_PAGE;
    }


}
