package com.example.educationcenter.repository;

import com.example.educationcenter.model.HomeWork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HomeWorkRepository extends JpaRepository<HomeWork,Integer> {
  

    List<HomeWork> findAllByUser_Id(int id);

    Optional<HomeWork> findHomeWorkById(int id);
}
