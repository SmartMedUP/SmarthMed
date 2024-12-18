package com.example.smartmed.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "patients")
public class Patient extends User {
    public Patient() {
        setUserType(UserType.PATIENT);
    }
    @Temporal(TemporalType.DATE)
    private Date birth_date;
    private String gender;
    private String address;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<MedicalRecord> medicalRecords;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Appointment> appointments;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<ChatbotInteraction> interactions;
}

