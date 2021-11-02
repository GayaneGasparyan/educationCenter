package com.example.educationcenter.repository;

import com.example.educationcenter.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Integer> {

    List<Message> findAllMessagesByToUser_Id(int id);

}
