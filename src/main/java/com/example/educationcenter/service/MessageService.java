package com.example.educationcenter.service;

import com.example.educationcenter.model.Message;

import java.util.List;

public interface MessageService {

    List<Message> findAllMessagesByToId(int id);


    void save(Message message);

}
