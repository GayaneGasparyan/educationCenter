package com.example.educationcenter.service;

import com.example.educationcenter.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {


    List<User> findAll();

    void deleteById(int id);

    Optional<User> findByEmail(String email);

    void deleteAllByCourseId(int id);

    void save(User user);

    List<User> findAllByCourseId(int courseId);


    Optional<User> getOne(int id);
}

