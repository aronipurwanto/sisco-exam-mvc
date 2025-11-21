package com.sisko.exam.siswa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/siswa")
public class SiswaController {

    @GetMapping
    public  String index() {
        return  "pages/siswa/index";
    }

    @GetMapping("/connections")
    public  String connections() {
        return  "pages/siswa/connections";
    }

    @GetMapping("/detail")
    public String detail(){
        return "pages/siswa/detail";
    }

    @GetMapping("/billing")
    public String billing(){
        return "pages/siswa/billing";
    }

    @GetMapping("/notification")
    public String notification(){
        return "pages/siswa/notification";
    }
}
