package com.spring.security.service;

import com.spring.security.dto.LoginRequestDTO;
import com.spring.security.dto.UserDTO;
import com.spring.security.exception.InvalidInputException;
import com.spring.security.model.Customer;
import com.spring.security.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements IUserService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;



    @Override
    public String registerUser(UserDTO userDTO) {
        if (userDTO == null) {
            throw new InvalidInputException("Missing required details");
        }

        String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());
        Customer customer = Customer.builder()
                .password(encryptedPassword)
                .email(userDTO.getUsername())
                .role(userDTO.getRole()).build();


        customerRepository.save(customer);
        log.info("Registered user: {}", customer);

        return "User registered successfully";
    }

    @Override
    public String login(LoginRequestDTO loginRequestDTO) {
        return  "User logged in successfully";
    }
}
