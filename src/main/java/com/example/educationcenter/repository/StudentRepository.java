package com.example.educationcenter.repository;

import com.example.educationcenter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<User,Integer> {
}
