package com.example.educationcenter.service;

import com.example.educationcenter.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> findAll();

    void save(Course course);

    void deleteById(int id);

    Optional<Course> getById(int id);
}
