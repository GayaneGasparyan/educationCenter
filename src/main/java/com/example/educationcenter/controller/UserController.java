package com.example.educationcenter.controller;

import com.example.educationcenter.model.Course;
import com.example.educationcenter.model.User;
import com.example.educationcenter.security.CurrentUser;
import com.example.educationcenter.service.CourseService;
import com.example.educationcenter.service.UserService;
import com.example.educationcenter.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userServiceImpl;
    private final UserService userService;


    private final PasswordEncoder passwordEncoder;
    private final CourseService courseService;

    @GetMapping("/users")
    public String users(ModelMap modelMap) {
        List<User> all = userService.findAll();
        modelMap.addAttribute("users", all);
       return "users";

    }




    @GetMapping("/addUser")
    public String addUser(ModelMap modelMap) {
        List<Course> all1 = courseService.findAll();
        modelMap.addAttribute("courses", all1);
        return "addUser";
    }

    @PostMapping("/admin/addUser")
    public String addUserPost(@ModelAttribute User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return "redirect:/users";
    }


    @GetMapping("/userDelete")
    public String deleteUser(@RequestParam int id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

}
