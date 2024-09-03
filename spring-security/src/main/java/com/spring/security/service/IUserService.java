package com.spring.security.service;

import com.spring.security.dto.LoginRequestDTO;
import com.spring.security.dto.UserDTO;

public interface IUserService {

    String registerUser(UserDTO userDTO);

   // UserDTO login(LoginRequestDTO loginRequestDTO);


    String login(LoginRequestDTO loginRequestDTO);

}
