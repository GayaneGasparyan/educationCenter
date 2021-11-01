package com.example.educationcenter.service;

import com.example.educationcenter.model.Message;

import java.util.List;

public interface MessageService {

    List<Message> findAllMessagesByToUserId(int id);


    void save(Message message);


}
