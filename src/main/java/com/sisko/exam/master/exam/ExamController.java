package com.sisko.exam.master.exam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/master/exams")
public class ExamController {

    @GetMapping
    public String index() {
        return "master/exam/index";
    }
}
