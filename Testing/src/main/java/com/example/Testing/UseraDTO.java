package com.example.Testing;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class UseraDTO {
    private String firstname;
    private String lastname;
    private String emailaddress;
    private int anniversaryYear;
}
