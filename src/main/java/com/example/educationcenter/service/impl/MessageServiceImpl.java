package com.example.educationcenter.service.impl;

import com.example.educationcenter.model.Message;
import com.example.educationcenter.repository.MessageRepository;
import com.example.educationcenter.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService{

    private final MessageRepository messageRepository;

    @Override
    public List<Message> findAllMessagesByToId(int id) {
        return messageRepository.findAllByToUser_id(id);
    }

    @Override
    public void save(Message message) {
         messageRepository.save(message);

    }

}
