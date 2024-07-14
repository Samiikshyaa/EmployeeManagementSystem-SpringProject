package com.bway.springproject.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;

@Controller
public class GalleryController {

    @GetMapping("/gallery")
    public String gallery(Model model, HttpSession session){
        if(session.getAttribute("validUser")==null){
            return "LoginForm";
        }
        String[] imgNames = new File("src/main/resources/static/images").list();
        model.addAttribute("imgList",imgNames);
        return "GalleryForm";
    }

}
