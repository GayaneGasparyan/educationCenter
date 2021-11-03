package com.example.educationcenter.controller;

import com.example.educationcenter.model.Course;
import com.example.educationcenter.model.User;
import com.example.educationcenter.security.CurrentUser;
import com.example.educationcenter.service.CourseService;
import com.example.educationcenter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final UserService userService;

    @GetMapping("/courses")
    public String getCourses(ModelMap modelMap) {
        List<Course> all = courseService.findAll();
        modelMap.addAttribute("courses", all);
        return "admin";
    }

    @GetMapping("/myCourse")
    public String getMyCourse(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        List<User> all = userService.findAllByCourseId(currentUser.getUser().getCourse().getId());
        modelMap.addAttribute("users", all);
        return "admin";
    }

    @PostMapping("/addCourse")
    public String addCoursePost(@ModelAttribute Course course) {
        courseService.save(course);
        return "redirect:/courses";
    }

    @GetMapping("/deleteCourse")

    public String deleteCourse(@RequestParam ("id") int id) {
        userService.deleteAllByCourseId(id);
        courseService.deleteById(id);
        return "redirect:/courses";
    }
}
