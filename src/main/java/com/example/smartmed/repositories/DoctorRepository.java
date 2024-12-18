package com.example.smartmed.repositories;
import com.example.smartmed.entities.Doctor;
import com.example.smartmed.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    //    Optional<Doctor> findByUserIdAndUserType(Integer userId, User.UserType userType);
}
