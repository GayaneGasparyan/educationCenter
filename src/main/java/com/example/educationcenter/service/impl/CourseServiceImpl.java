package com.example.educationcenter.service.impl;

import com.example.educationcenter.model.Course;
import com.example.educationcenter.repository.CourseRepository;
import com.example.educationcenter.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service

public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public void save(Course course) {

        courseRepository.save(course);
    }

    @Override
    public void deleteById(int id) {

        courseRepository.deleteById(id);
    }

    @Override
    public Optional<Course> getById(int id) {
       return courseRepository.findById(id);

    }

}
