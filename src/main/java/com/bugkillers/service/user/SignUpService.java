package com.bugkillers.service.user;

import com.bugkillers.domain.dto.LoginDto;
import com.bugkillers.domain.dto.SignUpDto;
import com.bugkillers.domain.entity.User;
import com.bugkillers.repository.UserRepository;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonIntegerFormatVisitor;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    final UserRepository userRepository;

    public SignUpService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signUp(SignUpDto signUpDto) {
        User user = new User();

        user.setPlatform_type(signUpDto.getPlatform_type());
        user.setAccess_token(signUpDto.getAccess_token());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(signUpDto.getPassword());
        user.setRole(signUpDto.getRole());
        user.setName(signUpDto.getName());
        user.setImage(signUpDto.getImage());
        user.setProfile(signUpDto.getProfile());

        userRepository.save(user);
    }
}
