package com.example.MyWebApp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
@RequestMapping("home")
//@ResponseBody
//by giving response body will print home.jsp in the browser(http://localhost:8080/home?name=smriti)
//to call the contents of home.jsp we need support(tomcat jasper dependency) cz springboot doesn't support jsp
	public String home(HttpServletRequest req)
	{
	    HttpSession session=req.getSession();
	    String name=req.getParameter("name");
		System.out.println("hiii"+ name);
		//hii smriti will be printed on console but only welcome will be there in browser so HttpSession is needed
		session.setAttribute("name", name);
		return "home";
	}
}
