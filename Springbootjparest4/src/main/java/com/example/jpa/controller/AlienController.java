package com.example.jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    @RequestMapping("/aliens")
    @ResponseBody
    //fetching by aid with the help of separate form in localhost:8080/aliens
    public List<Alien> getAliens()
    {
    	
    	return repo.findAll();
    
    }

	/*
	 * @RequestMapping("/alien/102")
	 * 
	 * @ResponseBody //fetching by aid with the help of separate form in
	 * localhost:8080/alien/102 will give info of specific alien public String
	 * getAlien() {
	 * 
	 * return repo.findById(102).toString();
	 * 
	 * }
	 */
    @RequestMapping("/alien/{aid}")
    @ResponseBody
    //fetching by aid with the help of separate form in localhost:8080/alien/102 will give info of specific alien
    public Optional<Alien> getAlien(@PathVariable("aid") int aid)
    {
    	
    	return repo.findById(aid);
    
    }
}