package com.example.educationcenter.repository;

import com.example.educationcenter.model.Comment;
import com.example.educationcenter.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

    List<Comment> findAllByHomework_id(int id);

}
