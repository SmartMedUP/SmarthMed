package com.example.smartmed.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctors")
public class Doctor extends User {
    private String specialty;
    private String license_number;
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<MedicalRecord> medicalRecords;
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

}
