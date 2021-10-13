package com.example.educationcenter.controller;

import com.example.educationcenter.service.impl.CourseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CourseController {
    private final CourseServiceImpl courseServiceImpl;
}
