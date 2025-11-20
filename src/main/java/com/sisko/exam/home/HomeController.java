package com.sisko.exam.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("pages/home/index");
    }

    @GetMapping("/dashboard")
    public ModelAndView dashboard(){
        return new ModelAndView("pages/home/dashboard");
    }
}
