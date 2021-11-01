package com.example.educationcenter.repository;

import com.example.educationcenter.model.HomeWork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HomeWorkRepository extends JpaRepository<HomeWork,Integer> {


    default List<HomeWork> findHomeWorkByUser_Course_Id(int id) {
        return null;
    }

    Optional<HomeWork> findHomeWorkById(int id);


    List<HomeWork> findByCourse_id(int id);
}
