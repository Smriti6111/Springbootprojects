package com.example.MyWebApp;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
@RequestMapping("home")

     //(http://localhost:8080/home?name=smriti)
    //to call the contents of home.jsp we need support(tomcat jasper dependency) cz springboot doesn't support jsp
	
		/*
		 * public String home(String name,HttpSession session) {
		 * System.out.println("hi"+name); session.setAttribute("name", name); return
		 * "home"; }
		 */

//public String home(String myName,HttpSession session)
//{
//    System.out.println("hi"+myName);
//    session.setAttribute("name", myName);
//	return "home";
//}
//(http://localhost:8080/home?myName=smriti)

//Now what if we have name in browsera nd myname in code

//public String home(@RequestParam("name") String myName,HttpSession session)
//{
//    System.out.println("hi"+myName);
//    session.setAttribute("name", myName);
//	return "home";
//}

//performing with model and view concept
 public ModelAndView home(@RequestParam("name")String myName) 
 { 
	 ModelAndView mv=new ModelAndView(); 
	 //session is used cz we are adding data into thesession object and that data is going to home.jsp 
     //dispatcher servlet needview and the data .view name is mv and data is name.
     mv.addObject("name",myName); 
     mv.setViewName("home"); 
     return mv; }
 
}
