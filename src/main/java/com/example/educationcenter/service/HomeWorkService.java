package com.example.educationcenter.service;

import com.example.educationcenter.model.HomeWork;

import java.util.List;
import java.util.Optional;

public interface HomeWorkService {
    List<HomeWork> findAllByUserId(int id);

    void save(HomeWork homeWork);

    Optional<HomeWork> findHomeWorkById(int id);

}
