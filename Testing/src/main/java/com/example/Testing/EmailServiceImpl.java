package com.example.Testing;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
//import org.thymeleaf.engine.TemplateModel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
@RestController
public class EmailServiceImpl implements EmailService {


    private TemplateModel templateModel;

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private TemplateEngine templateEngine;
    @Value("${spring.mail.username}")
    private String sender;

    @GetMapping("Sendmail")
    public String sendSimpleMail(@RequestBody EmailDetails details) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);

            // Set multiple recipients
            for (String recipient : details.getRecipient()) {
                mimeMessageHelper.addTo(recipient);
            }

            mimeMessageHelper.setSubject(details.getSubject());

            // Create template model
            TemplateModel templateModel = new TemplateModel();
            templateModel.setMessage(details.getMsgBody());

            // Convert image to base64
            String imageData = convertImageToBase64("src/main/resources/Images/bir.png");

            templateModel.setImage(imageData);

            // Set template model in Thymeleaf context
            Context context = new Context();
            context.setVariable("templateModel", templateModel);

            String emailContent = templateEngine.process("birthdaytemplate", context);

            mimeMessageHelper.setText(emailContent, true);
            javaMailSender.send(mimeMessage);
            return "Mail Sent Successfully...";
        } catch (MessagingException e) {
            e.printStackTrace(); // Handle exception appropriately
            return "Error while Sending Mail";
        }
    }

    public String convertImageToBase64(String imagePath) {
        try {
            Path path = Paths.get(imagePath);
            byte[] imageData = Files.readAllBytes(path);
            return Base64.getEncoder().encodeToString(imageData);
        } catch (IOException e) {
            e.printStackTrace(); // Handle exception appropriately
            return null;
        }

    }
}

// Define TemplateModel class


