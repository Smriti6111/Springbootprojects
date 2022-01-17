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
    	System.out.println(repo.findByTech("java"));
    	//localhost:8080 by giving 101 in submit query,it will search by technology i.e who is having java in tech and will print that in console
    	System.out.println(repo.findByAidGreaterThan(102));
    	//localhost:8080 by giving 101 in submit query,it will search by aid i.e whose aid is greater than 102 and will print all of thaem in console
    	System.out.println(repo.findByTechSorted("java"));
    	//localhost:8080 by giving 101 in submit query,it will search by technology in name sorted way i.e 
    	//whose name is in ascending order and will print all of thaem in console
    	mv.addObject(alien);
    	return mv;
    }
}