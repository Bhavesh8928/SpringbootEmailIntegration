package com.email.EmailAPI;

import com.email.EmailAPI.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;


@SpringBootApplication
public class EmailApiApplication {

//     This code is used to send default message to default email address whenever the application starts
    @Autowired
    private EmailService emailService;

    public static void main(String[] args) {
        SpringApplication.run(EmailApiApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void defaultAlert() {
        emailService.defaultAlert("bhavesh.rs.245@gmail.com",
                "Code Alert",
                "Some one is trying to run your code");
    }
}
