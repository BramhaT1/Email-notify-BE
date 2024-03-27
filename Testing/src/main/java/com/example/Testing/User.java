package com.example.Testing;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "main_users", schema = "sentrifugo_sagarsoft_live")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "emprole")
    private Long emprole;

    @Column(name = "userstatus")
    private String userstatus;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "userfullname")
    private String userfullname;

    @Column(name = "emailaddress")
    private String emailaddress;

    @Column(name = "contactnumber")
    private String contactnumber;

    @Column(name = "empipaddress")
    private String empipaddress;

    @Column(name = "backgroundchk_status")
    private String backgroundchk_status;

    @Column(name = "emptemplock")
    private Boolean emptemplock;

    @Column(name = "empreasonlocked")
    private String empreasonlocked;

    @Column(name = "emplockeddate")
    private Date emplockeddate;

    @Column(name = "emppassword")
    private String emppassword;

    @Column(name = "createdby")
    private Long createdby;

    @Column(name = "modifiedby")
    private Long modifiedby;

    @Column(name = "createddate")
    private Date createddate;

    @Column(name = "modifieddate")
    private Date modifieddate;

    @Column(name = "isactive")
    private Integer isactive;

    @Column(name = "employeeId")
    private String employeeId;

    @Column(name = "modeofentry")
    private String modeofentry;

    @Column(name = "other_modeofentry")
    private String other_modeofentry;

    @Column(name = "entrycomments")
    private String entrycomments;

    @Column(name = "rccandidatename")
    private Long rccandidatename;

    @Column(name = "selecteddate")
    private Date selecteddate;

    @Column(name = "candidatereferredby")
    private Long candidatereferredby;

    @Column(name = "company_id")
    private Long company_id;

    @Column(name = "profileimg")
    private String profileimg;

    @Column(name = "jobtitle_id")
    private Long jobtitle_id;

    @Column(name = "tourflag")
    private Boolean tourflag;

    @Column(name = "themes")
    private String themes;

    @Column(name = "emp_pay_type")
    private String emp_pay_type;

    @Column(name = "division_id")
    private Integer division_id;

    @Column(name = "prob_review_date")
    private Date prob_review_date;

    @Column(name = "unique_id")
    private String unique_id;

    @Column(name = "band_type")
    private String band_type;

    @Column(name = "login_time")
    private String login_time;

    @Column(name = "logout_time")
    private String logout_time;

    @Column(name = "working_hours")
    private Double working_hours;

    @Column(name = "exit_type")
    private Integer exit_type;

    @Column(name = "ist_offset")
    private String ist_offset;

    @Column(name = "ssma$rowid")
    private String ssma$rowid;


}

