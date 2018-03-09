package com.iquest.shoponline.controller;

import com.iquest.shoponline.constants.Views;
import com.iquest.shoponline.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public String showMain(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return Views.MAIN_PAGE;
    }

}
