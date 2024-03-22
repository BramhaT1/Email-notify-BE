package com.example.Testing;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private TemplateEngine templateEngine;
    @Value("${spring.mail.username}")
    private String sender;


    @GetMapping("Sendmail")
    public String sendSimpleMail(@RequestBody EmailDetails details) {
        try {
            BufferedImage image = ImageIO.read(new File("src/main/resources/templates/anni2.jpg"));
            Font font = new Font("Sans-serif", Font.BOLD, 65);
            String text = details.getName();
            Graphics g = image.getGraphics();
            FontMetrics metrics = g.getFontMetrics(font);
            int positionX = 55;//(image.getWidth() - metrics.stringWidth(text)) / 2;
            System.out.println(image.getWidth()+" "+image.getHeight());
            int positionY = 575;//(image.getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
            g.setFont(font);
            g.setColor(Color.RED);
            g.drawString(text, positionX, positionY);
            g.dispose();
            if (ImageIO.write(image, "png", new File("./output_image.png")))
            {
                System.out.println("-- saved");
            }

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            // Set multiple recipients
            for (String recipient : details.getRecipient()) {
                mimeMessageHelper.addTo(recipient);
            }

            mimeMessageHelper.setSubject(details.getSubject());
//                mimeMessageHelper.setSubject(details.getSubject());


            // Process template
            Context context = new Context();
            context.setVariable("message", details.getMsgBody());

            String emailContent = templateEngine.process("birthdaytemplate.html", context);

            mimeMessageHelper.setText(emailContent, true);
            ClassPathResource resource=new ClassPathResource("static\\output_image.png");
            mimeMessageHelper.addInline("imageId",resource);
            javaMailSender.send(mimeMessage);
            return "Mail Sent Successfully...";
        } catch (MessagingException e) {
            e.printStackTrace(); // Handle exception appropriately
            return "Error while Sending Mail";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //
//    public void addInlineImage(MimeMessageHelper mimeMessageHelper) throws MessagingException {
//        FileSystemResource image = new FileSystemResource("C:\\Users\\user\\Downloads\\Testing\\Testing\\src\\main\\resources\\Images\\bir.png");
//        mimeMessageHelper.addInline("logo", image);
//    }



}
