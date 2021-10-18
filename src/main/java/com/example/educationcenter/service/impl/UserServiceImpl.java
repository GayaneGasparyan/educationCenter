package com.example.educationcenter.service.impl;

import com.example.educationcenter.model.User;
import com.example.educationcenter.repository.UserRepository;
import com.example.educationcenter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {

        return userRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public Optional<User> findByEmail(String email) {

        return  userRepository.findByEmail(email);
    }

    @Override
    public List<User> findUserByCourseId(int id) {
        return userRepository.findUserByCourseId(id);
    }

    @Override
    public void deleteAllByCourseId(int id) {

    }

    @Override
    public void save(User user) {

    }
}
