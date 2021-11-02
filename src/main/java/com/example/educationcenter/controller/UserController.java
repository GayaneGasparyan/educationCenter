package com.example.educationcenter.controller;

import com.example.educationcenter.model.Course;
import com.example.educationcenter.model.User;
import com.example.educationcenter.model.UserType;
import com.example.educationcenter.security.CurrentUser;
import com.example.educationcenter.service.CourseService;
import com.example.educationcenter.service.UserService;
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
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserService userServiceImpl;
    private final CourseService courseService;


    private final PasswordEncoder passwordEncoder;


    @GetMapping("/user")
    public String userPage(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        modelMap.addAttribute("user", currentUser.getUsername());
        return "user";
    }

    @GetMapping("/users")
    public String users(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        List<User> all = userService.findAllByCourseId(currentUser.getUser().getCourse().getId());
        modelMap.addAttribute("users", all);
        return "users";
    }


    @PostMapping("/admin/addUser")
    public String addLecturersPost(@ModelAttribute User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return "redirect:/users";
    }


    @GetMapping("/admin")
    public String adminGet(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        modelMap.addAttribute("user", userServiceImpl.getOne(currentUser.getId()));
        List<User> user = userService.findAll();
        modelMap.addAttribute("users", user);
        List<Course> courseList = courseService.findAll();
        modelMap.addAttribute("courses", courseList);
        return "admin";
    }

    @GetMapping("/userDelete")
    public String deleteUser(@RequestParam int id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }


//    @PostMapping(value = "/user/update")
//    public String update(@ModelAttribute("user") User user, @RequestParam("id") int id) {
//        user.setId(id);
//        userService.save(user);
//        return "redirect:/admin";
//    }
//

    @GetMapping(value = "/studentUpdate")
    public String changeUserData(ModelMap map, @ModelAttribute("user") User user, @RequestParam("id") int id) {
        Optional<User> one = userServiceImpl.getOne(id);
        map.addAttribute("users", userServiceImpl.findAll());
        map.addAttribute("user", one.get());

        return "studentUpdate";
    }


 }