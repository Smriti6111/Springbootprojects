package com.example.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.jpa.model.Alien;

public interface AlienRepo extends CrudRepository<Alien,Integer>{

}
