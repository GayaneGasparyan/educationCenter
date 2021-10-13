package com.example.educationcenter.controller;

import com.example.educationcenter.model.Comment;
import com.example.educationcenter.model.HomeWork;
import com.example.educationcenter.security.CurrentUser;
import com.example.educationcenter.service.CommentService;
import com.example.educationcenter.service.HomeWorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class HomeWorkController {
    private final HomeWorkService homeWorkService;
    private final CommentService commentService;

    @GetMapping("/addHomeWork")
    public String addHomeWork() {
        return "addHomeWork";
    }

    @GetMapping("/homeWorks")
    public String viewHomeWorks(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        List<HomeWork> all = homeWorkService.findAllByUserId(currentUser.getUser().getCourse().getId());
        modelMap.addAttribute("homeWorks", all);
        return "homeWorks";
    }
    @PostMapping("/addHomeWork")
    public String addHomeWork(@AuthenticationPrincipal CurrentUser currentUser,@ModelAttribute HomeWork homeWork) {
        homeWork.setDeadline(new Date());
        homeWork.setUser(currentUser.getUser());
        homeWorkService.save(homeWork);
        return "redirect:/homeWorks";
    }
    @GetMapping("/homeWork/{id}")
    public String showMore(@PathVariable("id") int id, ModelMap modelMap) {
        Optional<HomeWork> homeWork=homeWorkService.findHomeWorkById(id);
        if (!homeWork.isPresent()){
            return "redirect:/homeWorks";
        }
        List<Comment> comments=commentService.getAllCommentsByHomeWorkId(id);
        modelMap.addAttribute("comments",comments);
        modelMap.addAttribute("homeWork",homeWork.get());
        return "singleHomeWork";
    }
}
