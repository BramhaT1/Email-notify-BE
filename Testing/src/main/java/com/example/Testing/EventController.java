package com.example.Testing;

import com.example.Testing.Event;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@CrossOrigin("*")
@RestController
public class EventController {
//
  @Autowired
   private EmailServiceImpl email;

  @Autowired
  UserRepo userRepo;

    @PostMapping("/store-events")
//    @Scheduled(cron = "0 0 6 * * *") // Run every day at 6 am
    public ResponseEntity<String> sendmails() {
        try {
            // Convert array to list for easier manipulation

            Date date=new Date();
//            List<String>  birthdayToday=new ArrayList<>();
//            List<String> test = userRepo.findActiveEmployeesNamesWithBirthdayToday(date);
//            System.out.println(test.get(0));
//            birthdayToday.add("Sai Charaan Reddy");
            List<UserDTO> birthdayUsers= new ArrayList<>();
            UserDTO user1=new UserDTO("Sreenivasa Ramanujan","Vadadaa","",date);
//            UserDTO user2=new UserDTO("Chandra Sekhar","Mora","",date);
//            UserDTO user3=new UserDTO("Shivani","Vachana","",date);
//            UserDTO user4=new UserDTO("Uday Kiran","Dasari","",date);
//            UserDTO user5=new UserDTO("Sai Charan Reddy","Nayanagari","",date);
            birthdayUsers.add(user1);
//            birthdayUsers.add(user2);
//            birthdayUsers.add(user3);
//            birthdayUsers.add(user4);birthdayUsers.add(user5);

//            birthdayUsers= userRepo.findActiveEmployeesWithBirthdayToday(date);

            List<UseraDTO> annniversaryUsers=new ArrayList<>();
//            UseraDTO usera1 = new UseraDTO("Bramha Teja","Kodavandlapalli","",4);
//            UseraDTO usera2 = new UseraDTO("Chandra Sekhar","Mora","",1);
//            UseraDTO usera5 = new UseraDTO("Uday Kiran","Dasari","",2);
//            UseraDTO usera3 = new UseraDTO("Abhiram Kumar","Danala","",8);
            UseraDTO usera4 = new UseraDTO("Navneet Sharmaa","Parsaa","",7);

//            annniversaryUsers.add(usera1);
//            annniversaryUsers.add(usera2);
//            annniversaryUsers.add(usera3);
            annniversaryUsers.add(usera4);
//            annniversaryUsers.add(usera5);
// "vachhanishivani423@gmail.com","ewwwaintakid@gmail.comm
//            abhiramdanala@gmail.com","vachhanishivani423@gmail.com,sreenivas.vadada@sagarsoft.in
            EmailDetails details = new EmailDetails( List.of("navneet.parsa@sagarsoft.in"), "Happy Birthday", "Birthday Greetings","","",0);
            EmailDetails detail = new EmailDetails( List.of("204g1a0584@srit.ac.in"), "", "Anniversary Greetings","","",0);
            for(UserDTO user:birthdayUsers){
                details.setFirstname(user.getFirstname());
                details.setLastname(user.getLastname());
//                String result = email.sendSimpleMail(details);
//                details.getRecipient().add(user.getEmailaddress());
            }
            for(UseraDTO user:annniversaryUsers){
                detail.setFirstname(user.getFirstname());
                detail.setLastname(user.getLastname());
                detail.setAnniversaryYear(user.getAnniversaryYear());
                String result = email.sendAnniversaryMail(detail);
//                details.getRecipient().add(user.getEmailaddress());
            }

//            for (String name : birthdayToday) {
//                details.setFirstname();
//                details.setLastName(lname);
//                String result = email.sendSimpleMail(details);
//            }
            return ResponseEntity.ok("Mails Triggered");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to trigger Mails " + e.getMessage());
        }
    }
}
