package com.bugkillers.service.user;

import com.bugkillers.domain.dto.LoginDto;
import com.bugkillers.domain.entity.User;
import com.bugkillers.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String login(LoginDto loginDto) {

        User user = userRepository.findByEmail(loginDto.getEmail());

        if (user.getEmail().equals(loginDto.getEmail())) {
            if (user.getPassword().equals(loginDto.getPassword())) {
                return user.getName();
            }
        }

        return "fail";

    }
}
