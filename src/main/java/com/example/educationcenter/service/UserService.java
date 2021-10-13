package com.example.educationcenter.service;

import com.example.educationcenter.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {


    List<User> findAll();

    void deleteById(int id);

    void addUser(User user);

    Optional<User> findByEmail(String email);

    List<User> findUserByCourseId(int id);
}
