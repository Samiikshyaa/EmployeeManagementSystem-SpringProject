package com.bway.springproject.controller;

import com.bway.springproject.model.User;
import com.bway.springproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userservice;

    @GetMapping({"/","/login"})
    public String getLogin(){
        return "LoginForm";
    }

    @PostMapping("/login")
    public String postlogin(@ModelAttribute User user){
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        User usr = userservice.userLogin(user.getEmail(),user.getPassword());
        if (usr != null){
            return "Home";
        }
        return "LoginForm";
    }

    @GetMapping("/signup")
    public String getSignup(){
        return "SignUp";
    }

    @PostMapping("/signup")
    public String postSignup(@ModelAttribute User u){
        u.setRole("Admin");
        u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
        userservice.userSignup(u);
        return "LoginForm";
    }
}
