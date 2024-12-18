package com.example.smartmed.repositories;
import com.example.smartmed.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
}
