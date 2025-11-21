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

    @GetMapping("/billing")
    public String billing(){
        return "pages/students/billing";
    }

    @GetMapping("/connection")
    public  String connections() {
        return "pages/students/connection";
    }

    @GetMapping("/course")
    public String course(){
        return "pages/students/course";
    }

    @GetMapping("/course/detail")
    public String courseDetail(){
        return "pages/students/course-detail";
    }

    @GetMapping("/profile")
    public String detail(){
        return "pages/students/profile";
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "pages/students/dashboard";
    }

    @GetMapping("/notification")
    public String notification(){
        return "pages/students/notification";
    }

    @GetMapping("/security")
    public String security(){
        return "pages/students/security";
    }
}
