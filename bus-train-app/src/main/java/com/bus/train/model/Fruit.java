package com.bus.train.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "fruits")
public class Fruit {
    @Id
    private int id;
    private String name;
    private String colour;

    
}