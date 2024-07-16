package com.bway.springproject.controller;

import com.bway.springproject.model.User;
import com.bway.springproject.service.UserService;
import com.bway.springproject.utils.VerifyRecaptcha;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class UserController {
    @Autowired
    private UserService userservice;

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

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
    public String postlogin(@ModelAttribute User user, Model model, HttpSession session, @RequestParam("g-recaptcha-response") String reCode) throws IOException {
        if (VerifyRecaptcha.verify(reCode)) {
            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
            User usr = userservice.userLogin(user.getEmail(), user.getPassword());
            if (usr != null) {
                log.info("-----------Login Success------------");
                session.setAttribute("validUser", usr);
                session.setMaxInactiveInterval(200);

                model.addAttribute("uname", usr.getFname());
                return "Home";
            }
        }
        log.info("========Login failed========");
        model.addAttribute("error", "You are not human!!");
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
        log.info("========Logout========");
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String profile(){
        return "Profile";
    }
}
