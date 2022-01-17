package com.example.jpa.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.jpa.model.Alien;

import java.util.List;

public interface AlienRepo extends CrudRepository<Alien,Integer>{

	
}
