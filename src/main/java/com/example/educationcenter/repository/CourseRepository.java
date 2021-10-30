package com.example.educationcenter.repository;

import com.example.educationcenter.model.Course;
import com.example.educationcenter.model.HomeWork;
import com.example.educationcenter.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course,Integer> {
    List<Course> findAllById(int id);

}
