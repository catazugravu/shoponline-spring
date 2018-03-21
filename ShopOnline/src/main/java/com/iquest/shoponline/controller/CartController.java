package com.iquest.shoponline.controller;

import com.iquest.shoponline.constants.SessionAttributes;
import com.iquest.shoponline.constants.Views;
import com.iquest.shoponline.dto.cart.CartDto;
import com.iquest.shoponline.dto.cartItem.CartItemDto;
import com.iquest.shoponline.dto.user.UserDto;
import com.iquest.shoponline.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/")
    public String getCart(Model model, HttpServletRequest request) {
        UserDto user = (UserDto) request.getSession().getAttribute(SessionAttributes.SESSION_USER);
        if (user != null) {
            CartDto cartDto = cartService.getCartForUser(user.getId());
            if (cartDto != null) {
                cartDto.setItems(cartService.getCartItemsForUser(user.getId()));
            } else {
                cartDto = new CartDto();
            }
            model.addAttribute("cart", cartDto);
            model.addAttribute("cartItem", new CartItemDto());
        }

        return Views.CART_PAGE;
    }

    @DeleteMapping("/{id}/item/{itemId}")
    public String deleteItemFromCart(@PathVariable("id") Integer cartId, @PathVariable("itemId") Integer itemId) {
        cartService.deleteItemFromCart(cartId, itemId);
        return Views.CART_PAGE;
    }

    @DeleteMapping("/{id}")
    public String deleteCart(@PathVariable("id") Integer cartId) {
        cartService.deleteCart(cartId);
        return Views.CART_PAGE;
    }

    @PostMapping("/{productId}")
    public String insertItemToCart(@PathVariable("productId") Integer productId, HttpServletRequest request) {
        UserDto user = (UserDto) request.getSession().getAttribute(SessionAttributes.SESSION_USER);
        if (user != null) {
            cartService.insertProductWith(user, productId);
        }
        return "redirect:/";
    }

    @PostMapping("/{id}/item/{itemId}")
    public String updateCartItem(@PathVariable("id") Integer cartId, @PathVariable("itemId") Integer itemId, @ModelAttribute("cartItem") CartItemDto cartItemDto) {
        cartService.updateItemQuantity(cartItemDto.getQuantity(), cartId, itemId);

        return "redirect:/cart/" + cartId;
    }
}
