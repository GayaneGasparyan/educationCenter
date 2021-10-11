package com.example.educationcenter.repository;

import com.example.educationcenter.model.HomeWork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<HomeWork,Integer> {
}
