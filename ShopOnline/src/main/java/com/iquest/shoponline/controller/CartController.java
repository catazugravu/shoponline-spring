package com.iquest.shoponline.controller;

import com.iquest.shoponline.constants.SessionAttributes;
import com.iquest.shoponline.constants.Views;
import com.iquest.shoponline.dto.cart.CartDto;
import com.iquest.shoponline.dto.cartItem.CartItemDto;
import com.iquest.shoponline.dto.user.UserAddressDto;
import com.iquest.shoponline.dto.user.UserDto;
import com.iquest.shoponline.services.CartService;
import com.iquest.shoponline.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    ProductService productService;

    @GetMapping
    public String getCart(Model model, HttpServletRequest request) {
        UserDto userSession = (UserDto) request.getSession().getAttribute(SessionAttributes.SESSION_USER);
        if (userSession != null) {
            CartDto cartDto = userSession.getCartDto();

            Integer userId = userSession.getId();
            if (userId != null) {
                cartService.updateUserCart(cartDto, userId);
            }

            double total = cartDto.getItems().stream().mapToDouble(cartItem -> cartItem.getQuantity() * cartItem.getPrice()).sum();
            model.addAttribute("total", total);
            model.addAttribute("cart", cartDto);
            model.addAttribute("addressForm", new UserAddressDto());
            model.addAttribute("cartItem", new CartItemDto());
        }

        return Views.CART_PAGE;
    }

    @PostMapping("/checkout")
    public String checkout(@ModelAttribute("addressForm") UserAddressDto userAddressDto, HttpServletRequest request) {
        UserDto userSession = (UserDto) request.getSession().getAttribute(SessionAttributes.SESSION_USER);
        if (userSession != null) {
            CartDto cartDto = userSession.getCartDto();

            Integer userId = userSession.getId();
            if (userId != null) {
                cartService.updateUserCart(cartDto, userId);
                cartService.createOrderFor(userId, userAddressDto.getAddress());
            }
        }

        return Views.ORDER_SUCCESSFUL;
    }

    @DeleteMapping("/{productId}")
    public String deleteItemFromCart(@PathVariable("productId") Integer productId, HttpServletRequest request) {
        UserDto userSession = (UserDto) request.getSession().getAttribute(SessionAttributes.SESSION_USER);
        if (userSession.getId() != null) {
            cartService.deleteItemFromDBCart(userSession.getId(), productId);
            userSession.setCartDto(cartService.getCartForUser(userSession.getId()));
        } else {
            cartService.deleteItemFromCartSession(userSession.getCartDto(), productId);
        }

        return "redirect:/" + Views.CART_PAGE;
    }

    @PostMapping("/{productId}")
    public String insertItemToCart(@PathVariable("productId") Integer productId, Model model, HttpServletRequest
            request) {
        UserDto user = (UserDto) request.getSession().getAttribute(SessionAttributes.SESSION_USER);
        if (user == null) {
            user = new UserDto();
            request.getSession().setAttribute(SessionAttributes.SESSION_USER, user);
        }

        CartDto cartDto = user.getCartDto();
        if (cartDto == null) {
            cartDto = new CartDto();
            user.setCartDto(cartDto);
        }

        cartService.addCartItemTo(cartDto, productId);

        model.addAttribute("product", productService.getProductById(productId));
        return Views.PRODUCT_INFO_PAGE;
    }

    @PostMapping("/update/{productId}")
    public String updateCartItem(@PathVariable("productId") Integer
                                         productId, @ModelAttribute("cartItem") CartItemDto cartItemDto, HttpServletRequest request) {
        UserDto userSession = (UserDto) request.getSession().getAttribute(SessionAttributes.SESSION_USER);
        if (userSession != null) {
            CartDto cartDto = userSession.getCartDto();
            if (cartDto != null) {
                cartService.updateItemQuantityFor(cartDto, cartItemDto.getProductId(), cartItemDto.getQuantity());
            }
        }

        return "redirect:/cart/";
    }
}
