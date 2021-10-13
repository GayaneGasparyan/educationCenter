package com.example.educationcenter.service.impl;

import com.example.educationcenter.model.Comment;
import com.example.educationcenter.repository.CommentRepository;
import com.example.educationcenter.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAllCommentsByHomeWorkId(int id) {
        return commentRepository.findAllByUserId(id);
    }


}
