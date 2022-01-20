package com.example.jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.jpa.dao.AlienRepo;
import com.example.jpa.model.Alien;

@RestController
public class AlienController {
	@Autowired
	AlienRepo repo;
	
    @RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
    
    @DeleteMapping("/alien/{aid}")
    public String deleteAlien(@PathVariable int aid)
    {
    	Alien a=repo.getOne(aid);
    	repo.delete(a);
    	return "deleted";
    }
    
    
    @PostMapping("/alien")
    //by using post in post man we can send any data and can check in h2 database
    public Alien addAlien(@RequestBody Alien alien)
  //to give raw data we need to give requestbody in the parameter
    //give this in postman ..raw..... in place of text use json
	/*
	 * { "aid":107,"aname":"Gordan","tech":"Robotics"} }
	 */
    //to access that http://localhost:8080/alien/107
    //for giving data from form to database
    {
    	repo.save(alien);
    	return alien;
    }
    //@RequestMapping("/aliens")
    //if no produces value is given like above  in 34th line then it can fetch data in xml and json both formats
  //@RequestMapping(path="/aliens",consumes= {"application/xml"})
    //server is accepting
    //@RequestMapping(path="/aliens",produces= {"application/xml"})
    //server is producing
    //like this we can restrict the json data from being fetched ..if we try to access application /json it will give error now..status 406 is shown
    //and only application/xml can be fetched
    @GetMapping("/aliens")

    //fetching by aid with the help of separate form in localhost:8080/aliens
    public List<Alien> getAliens()
    {
    	
    	return repo.findAll();
    
    }
     
    @PutMapping(path="/alien",consumes= {"application/json"})
    public Alien saveorupdateAlien(@RequestBody Alien alien)
    {
    	repo.save(alien);
    	return alien;
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
    //for this we can access both json and xml
 
    //fetching by aid with the help of separate form in localhost:8080/alien/102 will give info of specific alien
    //response body can be replaced from everywhere if we give rest controller
    public Optional<Alien> getAlien(@PathVariable("aid") int aid)
    {
    	
    	return repo.findById(aid);
    
    }
}