package com.iquest.ShopOnline.Controller;

import com.iquest.ShopOnline.Constants.Views;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/")
    public String showComingSoon() {
        return Views.MAIN_PAGE;
    }

}
