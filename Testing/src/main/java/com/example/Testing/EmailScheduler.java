//package com.example.Testing;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//import java.util.Arrays;
//import java.util.List;
//
//@Component
//public class EmailScheduler {
//
//
//    @Autowired
//    private EmailDetails details;
//    @Scheduled(fixedRate = 60000) // Check every minute
//    public void sendScheduledEmails() {
//        // Read data from the Excel sheet
//        List<Event> events = readEventsFromExcel();
//
//        // Get current date and time
//        LocalDateTime now = LocalDateTime.now();
//
//        // Iterate over events and send emails if their date and time match current date and time
//        for (Event event : events) {
//            LocalDateTime eventDateTime = LocalDateTime.of(event.getDate(), event.getTime());
//            if (eventDateTime.isEqual(now)) {
//
//                String reciepent= Arrays.toString(event.getEmailAddresses());
//                details.setRecipient(reciepent);
//                String subject=event.getSubject();
//                details.setRecipient(subject);
//                String message=event.getMessage();
//                EmailDetails details=new EmailDetails(reciepent,message,subject);
//
//                sendEmail(details);
//            }
//        }
//    }
//
//    // Method to read events from Excel sheet
//    private List<Event> readEventsFromExcel() {
//        // Implement reading logic from Excel sheet
//    }
//
//    // Method to send email
//    private void sendEmail(List<String> emailAddresses, String subject, String message) {
//        // Implement email sending logic using JavaMailSender
//    }
//}
