package com.example.Testing;

import lombok.Data;

import java.util.Date;

@Data
    public class UserDTO {
        private String firstname;
        private String lastname;
        private String emailaddress;
        private Date dob;

    public UserDTO(String firstname, String lastname, String emailaddress, Date dob) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailaddress = emailaddress;
        this.dob = dob;
    }


    }
