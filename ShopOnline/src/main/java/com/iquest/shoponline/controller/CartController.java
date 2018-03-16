package com.iquest.shoponline.controller;

import com.iquest.shoponline.constants.Views;
import com.iquest.shoponline.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/{id}")
    public String getCart(Model model) {
        //GetCartById
//        model.addAttribute("cart", cartService)
        return Views.CART_PAGE;
    }

    @GetMapping("/{id}/item/{itemId}")
    public String getItem(Model model) {
        //GetCartItemById
//        model.addAttribute("cart", cartService)
        return Views.CART_PAGE;
    }
}
