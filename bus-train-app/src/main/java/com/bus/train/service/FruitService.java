package com.bus.train.service;

import java.util.List;
import java.util.Optional;

import com.bus.train.model.Fruit;
import com.bus.train.repository.FruitsRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FruitService {
    private final FruitsRepository fruitsRepository;

    public List<Fruit> getFruits () {
        return fruitsRepository.findAll();
    }

    public Fruit getFruit(int id) {
        return fruitsRepository.findById(id).orElse(new Fruit());
    }
    
}