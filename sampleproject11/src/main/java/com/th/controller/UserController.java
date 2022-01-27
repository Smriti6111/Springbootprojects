package com.th.controller;

import com.th.Repo.Userrepo;
import com.th.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class UserController {
    @RequestMapping("/")
    public String Index() {
        return "index";
    }

    @RequestMapping("/signup")
    public String Signup() {
        return "Register";
    }

    @Autowired
    Userrepo ur;

    @RequestMapping("/register")
    public String Register(@ModelAttribute("user") User u) {
        ur.save(u);
    return "home";
    }

    @RequestMapping("/rest")
    public String login(@ModelAttribute("user") User u1) {
        Optional<User> searchUser = ur.findById(u1.getUsername());
        if (searchUser.isPresent()) {
            User c1 = searchUser.get();
            if (u1.getPassword().equals(c1.getPassword())) {
                System.out.println("success");
                return "home";
            }
            return "invalid";
        } else
            return "invalid";


    }
}
