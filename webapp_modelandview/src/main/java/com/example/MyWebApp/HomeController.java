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
	public ModelAndView home(@RequestParam("name")String myName)
	{
	    ModelAndView mv=new ModelAndView();
	     //session is used cz we are adding data into the session object and that data is going to home.jsp
	    //dispatcher servlet need view and the data .view name is mv and data is name.
		mv.addObject("name",myName);
		mv.setViewName("home");
		return mv;
	}
}
