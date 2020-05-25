package com.bugkillers.controller.user;

import com.bugkillers.domain.dto.LoginDto;
import com.bugkillers.domain.dto.SignUpDto;
import com.bugkillers.service.user.LoginService;
import com.bugkillers.service.user.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/sea")

public class UserController {
    private final LoginService loginService;
    private final SignUpService signUpService;

    public UserController(LoginService loginService, SignUpService signUpService) {
        this.loginService = loginService;
        this.signUpService = signUpService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto) {
        return loginService.login(loginDto);
    }

    @PostMapping("/signUp")
    public void signUp(@RequestBody SignUpDto signUpDto) {
        signUpService.signUp(signUpDto);
    }

}
