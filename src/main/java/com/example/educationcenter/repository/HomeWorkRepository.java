package com.example.educationcenter.repository;

import com.example.educationcenter.model.HomeWork;
import com.example.educationcenter.model.Message;
import com.example.educationcenter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HomeWorkRepository extends JpaRepository<HomeWork,Integer> {


    List<HomeWork> findHomeWorkByCourseId(int id);
    Optional<HomeWork> findHomeWorkById(int id);

    List<HomeWork> findAllHomeWorkById(int id);

    List<HomeWork> findByCourse_id(int id);
}
