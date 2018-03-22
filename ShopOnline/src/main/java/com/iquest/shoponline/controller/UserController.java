package com.iquest.shoponline.controller;

import com.iquest.shoponline.constants.SessionAttributes;
import com.iquest.shoponline.constants.Views;
import com.iquest.shoponline.dto.ErrorDto;
import com.iquest.shoponline.dto.user.UserDto;
import com.iquest.shoponline.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
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

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void addUser(@PathVariable UserDto userDto) {
        userService.create(userDto);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateUser(@PathVariable UserDto userDto) {
        userService.update(userDto);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public void deleteUser(@PathVariable Integer id) {
        userService.delete(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<UserDto> getAllUsers() {
        return userService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserDto getUser(@PathVariable Integer id) {
        return userService.findOne(id);
    }
}