package com.example.educationcenter.service.impl;

import com.example.educationcenter.model.HomeWork;
import com.example.educationcenter.repository.HomeWorkRepository;
import com.example.educationcenter.service.HomeWorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HomeWorkServiceImpl implements HomeWorkService {
    private final HomeWorkRepository homeWorkRepository;


    @Override
    public void save(HomeWork homeWork) {

        homeWorkRepository.save(homeWork);
    }

    @Override
    public Optional<HomeWork> findHomeWorkById(int id) {
        return homeWorkRepository.findHomeWorkById(id);
    }
}
