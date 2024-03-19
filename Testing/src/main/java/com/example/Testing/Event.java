package com.example.Testing;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class Event {
    private String eventName;
    private String DateTime;
    private String[] emailAddresses;
    private String message;
}
