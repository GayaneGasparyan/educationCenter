package com.example.educationcenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main() {
        return "home";
    }

    @GetMapping("/accessDenied")
    public String access() {
        return "403";
    }


}
