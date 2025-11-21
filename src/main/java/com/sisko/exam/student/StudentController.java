package com.sisko.exam.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {

    @GetMapping
    public  String index() {
        return  "pages/students/index";
    }

    @GetMapping("/connections")
    public  String connections() {
        return  "pages/students/connections";
    }

    @GetMapping("/detail")
    public String detail(){
        return "pages/students/detail";
    }

    @GetMapping("/billing")
    public String billing(){
        return "pages/students/billing";
    }

    @GetMapping("/notification")
    public String notification(){
        return "pages/students/notification";
    }
}
