package com.sisko.exam.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "pages/home/index";
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "pages/home/dashboard";
    }
}
