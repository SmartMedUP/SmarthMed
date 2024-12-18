package com.example.smartmed.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PatientDTO {
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String phone_number;
    private String created_at;
    private Date birth_date;
    private String gender;
    private String address;
}
