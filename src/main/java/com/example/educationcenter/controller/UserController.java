package com.example.educationcenter.controller;

import com.example.educationcenter.model.Course;
import com.example.educationcenter.model.User;
import com.example.educationcenter.model.UserType;
import com.example.educationcenter.security.CurrentUser;
import com.example.educationcenter.service.UserService;
import com.example.educationcenter.service.impl.CourseServiceImpl;
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
    private final CourseServiceImpl courseService;


    private final PasswordEncoder passwordEncoder;


    @GetMapping("/user")
    public String UserPage(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        modelMap.addAttribute("user", currentUser.getUsername());
        return "user";
    }

    @GetMapping("/users")
    public String users(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        List<User> allUsers = userServiceImpl.findAll();
        modelMap.addAttribute("allUsers", allUsers);
        List<User> all = userService.findUserByCourseId(currentUser.getUser().getId());
        if (currentUser.getUser().getUserType() == UserType.LECTURER) {
            return "lecturer";
        } else {
            return "users";
        }



    }

    @GetMapping("/addUser")
    public String addUser(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        List<Course> all = courseService.findAll();
        modelMap.addAttribute("course", all);
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addUser(user);
        return "redirect:/addUser";
    }


    @GetMapping("/userDelete")
    public String deleteUser(@RequestParam int id) {
        userService.deleteById(id);
        return "redirect:/user";
    }

}
