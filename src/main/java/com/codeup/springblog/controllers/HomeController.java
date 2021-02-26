package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String landingPage() {
        return "Welcome to the landing page!";
    }

    // no ResponseBody
//    @GetMapping("/home")
//    public String welcome() {
//        return "home";
//    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }


}
