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
    public List<Message> findAllMessagesByToUserId(int id) {
        return messageRepository.findAllMessagesByToUserId(id);
    }

    @Override
    public void save(Message message) {
         messageRepository.save(message);

    }

}
