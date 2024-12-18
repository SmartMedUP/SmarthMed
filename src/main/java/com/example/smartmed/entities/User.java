package com.example.smartmed.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String phone_number;
    private String created_at;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    public enum UserType {
        DOCTOR, PATIENT
    }



}