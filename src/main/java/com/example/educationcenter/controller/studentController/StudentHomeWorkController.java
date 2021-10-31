package com.example.educationcenter.controller.studentController;


import com.example.educationcenter.model.HomeWork;
import com.example.educationcenter.repository.HomeWorkRepository;
import com.example.educationcenter.security.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;


@Controller
@RequiredArgsConstructor
public class StudentHomeWorkController {

    private final HomeWorkRepository homeWorkRepository;



    @GetMapping("/myHomeWorks")
    public String getAllHomeWorks(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        List<HomeWork> all = homeWorkRepository.findByCourse_id(currentUser.getUser().getCourse().getId());
        modelMap.addAttribute("myHomeWorks", all);

        return "myHomeWorks";
    }


}
