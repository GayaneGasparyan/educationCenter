package com.example.educationcenter.controller.studentController;


import com.example.educationcenter.model.HomeWork;
import com.example.educationcenter.repository.HomeWorkRepository;
import com.example.educationcenter.security.CurrentUser;
import com.example.educationcenter.service.HomeWorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;


@Controller
@RequiredArgsConstructor
public class StudentHomeWorkController {

    private final HomeWorkService homeWorkService;



    @GetMapping("/myHomeWorks")
    public String getMyHomeWorks(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        List<HomeWork> all = homeWorkService.findHomeWorkByUserId(currentUser.getUser().getCourse().getId());
        modelMap.addAttribute("myHomeWorks", all);

        return "myHomeWorks";
    }


}
