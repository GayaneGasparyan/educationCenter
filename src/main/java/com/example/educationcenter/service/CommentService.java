package com.example.educationcenter.service;

import com.example.educationcenter.model.Comment;

import java.util.List;

public interface CommentService {
    void save(Comment comment);


    List<Comment> findAllCommentsByHomeWorkId(int id);

}
