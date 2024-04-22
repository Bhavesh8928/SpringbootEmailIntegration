package com.email.EmailAPI.controller;

import com.email.EmailAPI.entity.User;
import com.email.EmailAPI.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendemail")
    public String sendEmail(@RequestBody User user) {
        emailService.sendEmail(user);
        return "Email sent successfully";
    }
}
