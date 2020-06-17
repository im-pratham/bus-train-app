package com.bus.train.repository;

import com.bus.train.model.Fruit;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitsRepository extends JpaRepository<Fruit,String>{

    
}