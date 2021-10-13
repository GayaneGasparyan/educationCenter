package com.example.educationcenter.repository;

import com.example.educationcenter.model.Comment;
import com.example.educationcenter.model.HomeWork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeWorkRepository extends JpaRepository<HomeWork,Integer> {
}
