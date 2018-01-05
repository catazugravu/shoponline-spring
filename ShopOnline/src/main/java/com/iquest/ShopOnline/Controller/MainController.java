package com.iquest.ShopOnline.Controller;

import com.iquest.ShopOnline.Model.User;
import com.iquest.ShopOnline.Model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String showComingSoon() {
        return "index";
    }

}
