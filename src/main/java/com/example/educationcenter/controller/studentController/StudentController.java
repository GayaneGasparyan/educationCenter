package com.example.educationcenter.controller.studentController;

import com.example.educationcenter.model.User;
import com.example.educationcenter.security.CurrentUser;
import com.example.educationcenter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentController {
    private final UserService userService;

    @GetMapping("/student")
    public String users(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        List<User> all = userService.findAllByCourseId(currentUser.getUser().getCourse().getId());
        modelMap.addAttribute("users", all);
        return "student";
    }


}
