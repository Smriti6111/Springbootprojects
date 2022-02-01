package com.example.customer.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.customer.Repo.CustomerRepo;
import com.example.customer.model.*;
@Controller
public class CustomerController {
	@RequestMapping({"/","/invalid"})
	public String Index() {
		return "index";
	}
	
	@RequestMapping("/signup")
    public String Signup() {
        return "Register";
    }
	
	@RequestMapping("/register")
    public String Register(@ModelAttribute("customer") Customer c) {
        cr.save(c);
    return "index";
    }
@Autowired
CustomerRepo cr;

@RequestMapping("/rest")
public String login(@ModelAttribute("customer") Customer c1) {
    Optional<Customer> searchUser = cr.findById(c1.getUsername());
    if (searchUser.isPresent()) {
        Customer c2 = searchUser.get();
        if (c1.getPassword().equals(c2.getPassword())) {
            System.out.println("success");
            return "dashboard";
        }
        return "invalid";
    } else
        return "invalid";
}
}


