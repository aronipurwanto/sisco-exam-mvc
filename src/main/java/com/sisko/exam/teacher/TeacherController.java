package com.sisko.exam.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "pages/teacher/dashboard";
    }
}
