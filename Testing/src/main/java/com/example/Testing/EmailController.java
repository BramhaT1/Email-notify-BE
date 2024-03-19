package com.example.Testing;

import org.springframework.beans.factory.annotation.Autowired;

public class EmailController {

    @Autowired
    private EmailService emailService;

    public String sendMail(EmailDetails details)
    {
        return emailService.sendSimpleMail(details);
    }

}
