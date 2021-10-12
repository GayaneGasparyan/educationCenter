package com.example.educationcenter.repository;

import com.example.educationcenter.model.Course;
import com.example.educationcenter.model.HomeWork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}
