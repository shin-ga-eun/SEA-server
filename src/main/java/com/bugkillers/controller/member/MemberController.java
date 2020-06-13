package com.bugkillers.controller.member;

import com.bugkillers.domain.dto.member.LoginDto;
import com.bugkillers.domain.dto.member.SignUpDto;
import com.bugkillers.service.member.LoginService;
import com.bugkillers.service.member.SignUpService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/sea")

public class MemberController {
    private final LoginService loginService;
    private final SignUpService signUpService;

    public MemberController(LoginService loginService, SignUpService signUpService) {
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
