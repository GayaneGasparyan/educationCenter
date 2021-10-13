package com.example.educationcenter.service.impl;

import com.example.educationcenter.repository.CourseRepository;
import com.example.educationcenter.service.CourseServise;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

public class CourseServiceImpl implements CourseServise {
    private final CourseRepository courseRepository;
}
