package com.example.educationcenter.controller;

import com.example.educationcenter.model.Comment;
import com.example.educationcenter.security.CurrentUser;
import com.example.educationcenter.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;


    @PostMapping("/addComment")
    public String addComment(@ModelAttribute Comment comment, @AuthenticationPrincipal CurrentUser currentUser) {
        comment.setUser(currentUser.getUser());
        commentService.save(comment);

        return "redirect:/homeWorks/" + comment.getHomework().getId();
    }


}
