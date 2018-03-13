package com.iquest.shoponline.controller;

import com.iquest.shoponline.constants.SessionAttributes;
import com.iquest.shoponline.constants.Views;
import com.iquest.shoponline.dto.ErrorDto;
import com.iquest.shoponline.dto.user.UserDto;
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

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginFormUser", new UserDto());
        return Views.LOGIN_PAGE;
    }

    @PostMapping("/login")
    public String login(Model model, @ModelAttribute("loginFormUser") UserDto loginFormUser, HttpServletRequest request) {
        Optional<UserDto> user = userService.getByEmailAndHash(loginFormUser.getEmail(), loginFormUser.getPassword());
        if (user.isPresent()) {
            request.getSession().setAttribute(SessionAttributes.SESSION_USER, user.get());
            return "redirect:/";
        } else {
            model.addAttribute("error", new ErrorDto("00001", "Username or password are invalid."));
            return Views.LOGIN_PAGE;

        }

    }
}
