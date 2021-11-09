package com.example.educationcenter.controller;

import com.example.educationcenter.model.Course;
import com.example.educationcenter.model.User;

import com.example.educationcenter.security.CurrentUser;
import com.example.educationcenter.service.CourseService;
import com.example.educationcenter.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;
    private final CourseService courseService;

    private final PasswordEncoder passwordEncoder;


    @GetMapping("/admin")
    public String adminGet(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        modelMap.addAttribute("user", userService.getOne(currentUser.getUser().getId()));
        List<User> user = userService.findAll();
        modelMap.addAttribute("users", user);
        List<Course> courseList = courseService.findAll();
        modelMap.addAttribute("courses", courseList);
        log.info("User with {} username opened admin page", currentUser.getUser().getEmail());

        return "admin";
    }

    @PostMapping("/admin/addUser")
    public String addLecturersPost(@ModelAttribute User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return "redirect:/admin";
    }



    @GetMapping("/userDelete")
    public String deleteUser(@RequestParam int id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }


    @GetMapping(value = "/studentUpdate")
    public String changeUserData(ModelMap map, @ModelAttribute("user") User user, @RequestParam("id") int id,@AuthenticationPrincipal CurrentUser currentUser) {
        Optional<User> one = userService.getOne(id);
        map.addAttribute("users", userService.findAll());
        map.addAttribute("user", one.get());
        List<Course> list = courseService.findAll();
       map.addAttribute("courses", list);
       log.info("User with {} username updates user data",currentUser.getUser().getEmail()) ;

        return "studentUpdate";
    }


}