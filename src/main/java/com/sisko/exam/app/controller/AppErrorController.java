package com.sisko.exam.app.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                model.addAttribute("errorCode", "404");
                model.addAttribute("errorMessage", "Halaman yang Anda cari tidak ditemukan.");
                return  "errors/not-found";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                model.addAttribute("errorCode", "500");
                model.addAttribute("errorMessage", "Terjadi kesalahan pada server kami.");
                return "errors/internal-server-error";
            }
            else if(statusCode == HttpStatus.FORBIDDEN.value()) {
                model.addAttribute("errorCode", "500");
                model.addAttribute("errorMessage", "Terjadi kesalahan pada server kami.");
                return "errors/forbidden";
            }
            else if(statusCode == HttpStatus.UNAUTHORIZED.value()) {
                model.addAttribute("errorCode", "500");
                model.addAttribute("errorMessage", "Terjadi kesalahan pada server kami.");
                return "errors/unauthorized";
            }
            else {
                model.addAttribute("errorCode", statusCode);
                model.addAttribute("errorMessage", "Terjadi kesalahan yang tidak diketahui.");
            }
        }
        return "errors/under-maintenance";
    }

    @RequestMapping("/403")
    public String forbidden(){
        return  "errors/forbidden";
    }

    @RequestMapping("/401")
    public String unauthorized(){
        return "errors/unauthorized";
    }

    @RequestMapping("/500")
    public String internalServerError(){
        return "errors/internal-server-error";
    }
}
