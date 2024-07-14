package com.bway.springproject.controller;

import com.bway.springproject.model.User;
import com.bway.springproject.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userservice;

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "LoginForm";
    }

    @GetMapping("/home")
    public String getHome() {
        return "Home";
    }

    @PostMapping("/login")
    public String postlogin(@ModelAttribute User user, Model model, HttpSession session) {
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        User usr = userservice.userLogin(user.getEmail(), user.getPassword());
        if (usr != null) {
            session.setAttribute("validUser", usr);
            session.setMaxInactiveInterval(200);

            model.addAttribute("uname", usr.getFname());
            return "Home";
        }
        model.addAttribute("error", "User not found!");
        return "LoginForm";
    }

    @GetMapping("/signup")
    public String getSignup() {
        return "SignUp";
    }

    @PostMapping("/signup")
    public String postSignup(@ModelAttribute User u) {
        u.setRole("Admin");
        u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
        userservice.userSignup(u);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }
}
