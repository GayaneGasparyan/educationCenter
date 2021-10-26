package com.example.educationcenter.controller;

import com.example.educationcenter.model.Comment;
import com.example.educationcenter.model.Course;
import com.example.educationcenter.model.HomeWork;
import com.example.educationcenter.repository.HomeWorkRepository;
import com.example.educationcenter.security.CurrentUser;
import com.example.educationcenter.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final HomeWorkRepository homeWorkRepository;


    @PostMapping("/addComment")
    public String addComment(@ModelAttribute Comment comment, @AuthenticationPrincipal CurrentUser currentUser) {
        comment.setUser(currentUser.getUser());
        commentService.save(comment);

        return "redirect:/homeWorks/"+comment.getHomework().getId();
    }


}
