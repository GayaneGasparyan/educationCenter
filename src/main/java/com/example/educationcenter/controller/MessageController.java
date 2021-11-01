package com.example.educationcenter.controller;

import com.example.educationcenter.model.Message;
import com.example.educationcenter.model.User;
import com.example.educationcenter.security.CurrentUser;
import com.example.educationcenter.service.MessageService;
import com.example.educationcenter.service.UserService;
import com.example.educationcenter.service.impl.MessageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final UserService userService;
    private final MessageService messageService;

    @GetMapping("/messages")
    public String getAllUsers(ModelMap modelMap) {
        List<User> all = userService.findAll();
        modelMap.addAttribute("users", all);
        return "messages";

    }

    @GetMapping("/showMessages")
    public String getAllMessages(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        List<Message> all = messageService.findAllMessagesByToUserId(currentUser.getUser().getId());
        modelMap.addAttribute("messages", all);

        return "myMessages";
    }

    @PostMapping("/messages")
    public String sendMessage(@ModelAttribute Message message, @AuthenticationPrincipal CurrentUser currentUser) {
        message.setUser(currentUser.getUser());
        messageService.save(message);
        return "redirect:/messages";

        }
}
