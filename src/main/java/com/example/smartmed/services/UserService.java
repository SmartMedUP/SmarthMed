package com.example.smartmed.services;

import com.example.smartmed.entities.Doctor;
import com.example.smartmed.entities.Patient;
import com.example.smartmed.entities.User;
import com.example.smartmed.repositories.PatientRepository;
import com.example.smartmed.repositories.DoctorRepository;
import com.example.smartmed.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Transactional
    public User createUser(User user) {
        if (user.getUserType() == User.UserType.PATIENT) {
            Patient patient = (Patient) user;
            patient.setUserType(User.UserType.PATIENT);
            return patientRepository.save(patient);
        }
        else if (user.getUserType() == User.UserType.DOCTOR) {
            Doctor doctor = (Doctor) user;
            doctor.setUserType(User.UserType.DOCTOR);
            return doctorRepository.save(doctor);}
        else {
            return userRepository.save(user);

        }
    }
}



