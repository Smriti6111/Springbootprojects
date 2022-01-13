package com.example.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @RequestMapping("/getAlien")
    //fetching by aid with the help of separate form in localhost:8080
    public ModelAndView getAlien(@RequestParam int aid)
    {
    	ModelAndView mv=new ModelAndView("showAlien.jsp");
    	Alien alien=repo.findById(aid).orElse(new Alien());
    	mv.addObject(alien);
    	return mv;
    }
}