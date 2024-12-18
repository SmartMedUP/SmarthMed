package com.example.smartmed.controllers;

import com.example.smartmed.dto.DoctorDTO;
import com.example.smartmed.dto.PatientDTO;
import com.example.smartmed.entities.Doctor;
import com.example.smartmed.entities.Patient;
import com.example.smartmed.entities.User;
import com.example.smartmed.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create-patient")
    public ResponseEntity<Patient> createPatient(@Valid @RequestBody PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setFirst_name(patientDTO.getFirst_name());
        patient.setLast_name(patientDTO.getLast_name());
        patient.setEmail(patientDTO.getEmail());
        patient.setPassword(patientDTO.getPassword());
        patient.setPhone_number(patientDTO.getPhone_number());
        patient.setCreated_at(patientDTO.getCreated_at());
        patient.setBirth_date(patientDTO.getBirth_date());
        patient.setGender(patientDTO.getGender());
        patient.setAddress(patientDTO.getAddress());
        Patient savedPatient = (Patient) userService.createUser(patient);
        return ResponseEntity.ok(savedPatient);
    }

    @PostMapping("/create-doctor")
    public ResponseEntity<Doctor> createDoctor(@Valid @RequestBody DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();
        doctor.setFirst_name(doctorDTO.getFirst_name());
        doctor.setLast_name(doctorDTO.getLast_name());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setPassword(doctorDTO.getPassword());
        doctor.setPhone_number(doctorDTO.getPhone_number());
        doctor.setCreated_at(doctorDTO.getCreated_at());
        doctor.setSpecialty(doctorDTO.getSpecialty());
        doctor.setLicense_number(doctorDTO.getLicense_number());
        Doctor savedDoctor = (Doctor) userService.createUser(doctor);
        return ResponseEntity.ok(savedDoctor);
    }


}

