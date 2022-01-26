package com.example.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.model.Alien;

public interface AlienRepo extends JpaRepository<Alien,Integer>{

	
}
