package com.example.MyWebApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
@RequestMapping("home")
//@ResponseBody
//by giving response body will print home.jsp in the browser(http://localhost:8080/home)
//to call the contents of home.jsp we need support(tomcat jasper dependency) cz springboot doesn't support jsp
	public String home()
	{
		System.out.println("hiii");
		return "home";
	}
}
