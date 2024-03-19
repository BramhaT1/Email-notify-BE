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
import java.io.File;
@RestController
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private TemplateEngine templateEngine;
    @Value("${spring.mail.username}")
    private String sender;


    @GetMapping("Sendmail")
    public String sendSimpleMail(@RequestBody  EmailDetails details) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            // Set multiple recipients
            for (String recipient : details.getRecipient()) {
                mimeMessageHelper.addTo(recipient);
            }

            mimeMessageHelper.setSubject(details.getSubject());
            mimeMessageHelper.setSubject(details.getSubject());

            // Process template
            Context context = new Context();
            context.setVariable("message", details.getMsgBody());
           // context.setVariable("image","logo");
            addInlineImage(mimeMessageHelper);
            String emailContent = templateEngine.process("emailTemplate", context);

            mimeMessageHelper.setText(emailContent, true);
            javaMailSender.send(mimeMessage);
            return "Mail Sent Successfully...";
        } catch (MessagingException e) {
            e.printStackTrace(); // Handle exception appropriately
            return "Error while Sending Mail";
        }
    }

    public void addInlineImage(MimeMessageHelper mimeMessageHelper) throws MessagingException {
        FileSystemResource image = new FileSystemResource(new File("src/main/resources/Images/download.jpg"));
        mimeMessageHelper.addInline("logo", image);
    }
}
