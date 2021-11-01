package com.example.educationcenter.service;

import com.example.educationcenter.model.HomeWork;

import java.util.List;
import java.util.Optional;

public interface HomeWorkService {

    void save(HomeWork homeWork);

    List <HomeWork> findHomeWorkByUserId(int id);



    Optional<HomeWork> findHomeWorkById(int id);
}
