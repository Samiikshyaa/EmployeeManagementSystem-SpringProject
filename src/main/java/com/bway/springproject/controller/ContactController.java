package com.bway.springproject.controller;

import com.bway.springproject.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {
    @Autowired
    private MailUtils mailUtils;

    @GetMapping("/contact")
    public String getContact(){
        return "ContactForm";
    }

    @PostMapping("/contact")
    public String postContact(@RequestParam String toemail, @RequestParam String subject, @RequestParam String message){
        mailUtils.sendEmail(toemail, subject, message);
        return "ContactForm";
    }
}
