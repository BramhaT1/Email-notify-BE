//package com.example.Testing;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class ScheduleController {
//
//    @Value("${cron.default.expression}")
//    private String defaultCronExpression;
//
//    private boolean isPaused = false; // Initial value
//
////    @PostMapping("/update-schedule")
////    public String updateSchedule(@ModelAttribute("scheduleForm") ScheduleForm scheduleForm, Model model) {
////        // Logic to update the cron expression in your backend
////        String newCronExpression = scheduleForm.getCronExpression();
////        // You may want to validate the cron expression here
////
////        // Update the cron expression in your backend
////        // For simplicity, I'm just printing the new expression here
////        System.out.println("New Cron Expression: " + newCronExpression);
////
////        // Add a success message to display on the frontend
////        model.addAttribute("message", "Schedule updated successfully!");
////
////        return "schedule-page";
////    }
//
//    @PostMapping("/pause")
//    public String pauseSchedule(Model model) {
//        isPaused = true;
//        model.addAttribute("message", "Schedule paused successfully!");
//        return "schedule-page";
//    }
//
//    @PostMapping("/resume")
//    public String resumeSchedule(Model model) {
//        isPaused = false;
//        model.addAttribute("message", "Schedule resumed successfully!");
//        return "schedule-page";
//    }
//
//    @GetMapping("/schedule-page")
//    public String showSchedulePage(Model model) {
//        // Add default cron expression to the form
//        ScheduleForm scheduleForm = new ScheduleForm();
//        scheduleForm.setCronExpression(defaultCronExpression);
//        scheduleForm.setPaused(isPaused); // Set pause status
//        model.addAttribute("scheduleForm", scheduleForm);
//
//        return "schedule-page";
//    }
//}
