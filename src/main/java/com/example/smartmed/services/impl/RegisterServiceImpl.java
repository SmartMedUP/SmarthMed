package com.example.smartmed.services.impl;


import com.example.smartmed.dtos.SignupRequest;
import com.example.smartmed.models.User;
import com.example.smartmed.repositories.UserRepository;
import com.example.smartmed.services.RegisterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User createUser(SignupRequest signupRequest) {
        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            return null;
        }
        User user = new User();
        BeanUtils.copyProperties(signupRequest,user);
        String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
        user.setPassword(hashPassword);
        User createdCustomer = userRepository.save(user);
        user.setUser_id(createdCustomer.getUser_id());
        return user;
    }
}
