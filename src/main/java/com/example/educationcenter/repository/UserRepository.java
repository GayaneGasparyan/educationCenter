package com.example.educationcenter.repository;

import com.example.educationcenter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String s);

    void deleteAllByCourseId(int id);

    List<User> findAllByCourseId(int id);

    Optional<User> findOneById(int id);
}
