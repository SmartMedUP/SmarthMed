package com.example.smartmed.repositories;
import com.example.smartmed.entities.Patient;
import com.example.smartmed.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Optional<Patient> findByUserIdAndUserType(Integer userId, User.UserType userType);

}
