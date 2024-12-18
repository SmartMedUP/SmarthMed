package com.example.smartmed.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorDTO {
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String phone_number;
    private String created_at;
    private String specialty;
    private String license_number;
}
