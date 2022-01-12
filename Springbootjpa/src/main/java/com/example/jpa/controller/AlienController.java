package com.example.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.jpa.dao.AlienRepo;
import com.example.jpa.model.Alien;

@Controller
public class AlienController {
	@Autowired
	AlienRepo repo;
	
    @RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
    @RequestMapping("/addAlien")
    public String addAlien(Alien alien)
    //for giving data from form to database
    {
    	repo.save(alien);
    	return "home.jsp";
    }
}
