package com.sisko.exam.home;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication){
        if (authentication != null) {
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                String role = authority.getAuthority();
                if ("ROLE_STUDENT".equals(role)) {
                    return "redirect:/students/dashboard";
                } else if ("ROLE_TEACHER".equals(role)) {
                    return "redirect:/teachers/dashboard";
                } else if ("ROLE_ADMIN".equals(role)) {
                    return "redirect:/admin/dashboard";
                }
            }
        }
        // Default redirect if no role matches or not authenticated
        return "redirect:/401";
    }
}
