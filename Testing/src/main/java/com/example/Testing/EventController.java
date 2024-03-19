package com.example.Testing;

import com.example.Testing.Event;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@CrossOrigin("*")
@RestController
public class EventController {
//
  @Autowired
   private EmailServiceImpl email;



    @PostMapping("/store-events")
    public ResponseEntity<String> storeEvents(@RequestBody Event[] events) {
        try {
            // Convert array to list for easier manipulation
            System.out.println(events);
            List<Event> eventList = Arrays.asList(events);
//            LocalDateTime currentDateTime = LocalDateTime.now();
            LocalDate currentDateTime=LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.println(currentDateTime);

            for (Event event : eventList) {
                String eventName = event.getEventName();
                String message = event.getMessage();
                String eventDateTimeString = event.getDateTime();
                System.out.println(eventDateTimeString);
                LocalDate eventDateTime = LocalDate.parse(eventDateTimeString, formatter);
                List<String> emailAddresses = List.of(event.getEmailAddresses());

                if (eventDateTime.isEqual(currentDateTime)) {
                    EmailDetails details = new EmailDetails(emailAddresses, message, eventName);
                    String result = email.sendSimpleMail(details);
                    System.out.println(result); // Print the result of sending the email
                }
            }
            return ResponseEntity.ok("Events stored successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to store events: " + e.getMessage());
        }
    }
}
