package com.example.educationcenter.service.impl;

import com.example.educationcenter.repository.CourseRepository;
import com.example.educationcenter.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
}
