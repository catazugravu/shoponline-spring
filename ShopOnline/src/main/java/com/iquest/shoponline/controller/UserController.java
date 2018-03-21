package com.iquest.shoponline.controller;

import com.iquest.shoponline.constants.SessionAttributes;
import com.iquest.shoponline.constants.Views;
import com.iquest.shoponline.dto.ErrorDto;
import com.iquest.shoponline.dto.cart.CartDto;
import com.iquest.shoponline.dto.user.UserDto;
import com.iquest.shoponline.services.CartService;
import com.iquest.shoponline.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    CartService cartService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginFormUser", new UserDto());
        return Views.LOGIN_PAGE;
    }

    @PostMapping("/login")
    public String login(Model model, @ModelAttribute("loginFormUser") UserDto loginFormUser, HttpServletRequest request) {
        Optional<UserDto> user = userService.getByEmailAndHash(loginFormUser.getEmail(), loginFormUser.getPassword());
        if (user.isPresent()) {
            UserDto userDto = user.get();
            CartDto cart = cartService.getCartForUser(userDto.getId());

            if (cart == null) {
                cart = (CartDto) request.getSession().getAttribute(SessionAttributes.SESSION_CART);
            }
            userDto.setCartDto(cart);

            request.getSession().setAttribute(SessionAttributes.SESSION_USER, userDto);
            return "redirect:/";
        } else {
            model.addAttribute("error", new ErrorDto("00001", "Username or password are invalid."));
            return Views.LOGIN_PAGE;

        }

    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        cartService.updateUserCart((CartDto) request.getSession().getAttribute(SessionAttributes.SESSION_CART));
        return "redirect:/";
    }
}
