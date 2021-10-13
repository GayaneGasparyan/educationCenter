package com.example.educationcenter.controller;

import com.example.educationcenter.model.Comment;
import com.example.educationcenter.security.CurrentUser;
import com.example.educationcenter.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
@RequiredArgsConstructor
public class CommentController {
    private  final CommentService commentService;


    @PostMapping("/addComment")
    public String addComment(@AuthenticationPrincipal CurrentUser currentUser, @ModelAttribute Comment comment) {
        comment.setUser(currentUser.getUser());
        commentService.save(comment);
        return "redirect:/homework/" + comment.getHome_work().getId();
    }
}
