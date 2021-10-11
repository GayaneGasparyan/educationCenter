package com.example.educationcenter.repository;

import com.example.educationcenter.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturerRepository extends JpaRepository<Message,Integer> {
}
