package com.example.educationcenter.controller;

import com.example.educationcenter.model.Comment;
import com.example.educationcenter.model.Course;
import com.example.educationcenter.model.HomeWork;
import com.example.educationcenter.model.Message;
import com.example.educationcenter.repository.CommentRepository;
import com.example.educationcenter.repository.CourseRepository;
import com.example.educationcenter.repository.HomeWorkRepository;
import com.example.educationcenter.security.CurrentUser;
import com.example.educationcenter.service.CommentService;
import com.example.educationcenter.service.HomeWorkService;
import com.example.educationcenter.service.impl.CommentServiceImpl;
import com.example.educationcenter.service.impl.CourseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class HomeWorkController {
    private final HomeWorkService homeWorkService;
    private final CommentServiceImpl commentService;
    private final CourseServiceImpl courseService;
    private final CourseRepository courseRepository;
    private final HomeWorkRepository homeWorkRepository;
    private final CommentRepository commentRepository;

    @GetMapping("/addHomeWork")
    public String addHomeWork() {
        return "addHomeWork";
    }


    @PostMapping("/addHomeWork")
    public String addHomeWork(@ModelAttribute HomeWork homeWork, @AuthenticationPrincipal CurrentUser currentUser) {
       homeWork.setCourse(currentUser.getUser().getCourse());
        homeWorkService.save(homeWork);
        return "redirect:/homeWorks";
    }

    @GetMapping("/homeWorks")
    public String getAllHomeWorks(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        List<HomeWork> all = homeWorkRepository.findByCourse_id(currentUser.getUser().getCourse().getId());
        modelMap.addAttribute("homeWorks", all);

        return "homeWorks";
    }
    @GetMapping("/homeWorks/{id}")
    public String singleHomWork(@PathVariable ("id") int id, ModelMap modelMap){
        Optional<HomeWork> homeWork=homeWorkRepository.findHomeWorkById(id);
        if(homeWork.isEmpty()){
            return "redirect:/homeWorks";
        }
        List<Comment> comments=commentRepository.findAllByHomework_id(id);
        modelMap.addAttribute("comments", comments);
        modelMap.addAttribute("homework", homeWork.get());
        return "singleHomeWork";

    }

}

