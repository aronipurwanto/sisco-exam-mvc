package com.sisko.exam.master.level;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/master/levels")
public class LevelController {
    @GetMapping
    public String index() {
        return "master/level/index";
    }
}
