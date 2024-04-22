package com.email.EmailAPI.service;

import com.email.EmailAPI.entity.User;
import com.email.EmailAPI.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender javaMailSender;  // This is the interface used to send the email

    public void defaultAlert(String email, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("gamer641boy@gmail.com");
        mailMessage.setTo(email);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        javaMailSender.send(mailMessage);
    }

    public User sendEmail(User user) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        // To send email to multiple users, use the following code:
        mailMessage.setFrom("gamer641boy@gmail.com");
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject(user.getSubject());
        mailMessage.setText(user.getMessage());
        System.out.println("Message sent successfully to " + user.getEmail());

        javaMailSender.send(mailMessage);

        // To save the email to the database, use the following code:
        User mailData = new User();
        mailData.setEmail(user.getEmail());
        mailData.setSubject(user.getSubject());
        mailData.setMessage(user.getMessage());
        return emailRepository.save(mailData);
    }

}
