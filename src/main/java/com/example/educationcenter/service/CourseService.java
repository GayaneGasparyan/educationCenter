package com.example.educationcenter.service;

import com.example.educationcenter.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();

    void save(Course course);

    void deleteById(int id);

}
