package com.example.educationcenter.controller;

import com.example.educationcenter.model.User;
import com.example.educationcenter.model.UserType;
import com.example.educationcenter.security.CurrentUser;
import com.example.educationcenter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class MainController {
    private final UserService userService;

    @GetMapping("/")
    public String main(ModelMap modelMap) {
        List<User> user =userService.findAll();
        modelMap.addAttribute("users",user);
        return "home";
    }

    @GetMapping("/accessDenied")
    public String access() {
        return "403";
    }


    @RequestMapping(value = "/loginSuccess", method = RequestMethod.GET)
    public String loginSuccess() {
        CurrentUser principal = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal.getUser().getUserType() == UserType.ADMIN) {
            return "redirect:/admin";
        }
        if (principal.getUser().getUserType() == UserType.LECTURER) {
            return "redirect:/lecturer";
        }
        if (principal.getUser().getUserType() == UserType.STUDENT) {
            return "redirect:/student";
        }
        return "redirect:/";
    }



}
