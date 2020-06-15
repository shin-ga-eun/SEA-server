package com.bugkillers.domain.member.controller;

import com.bugkillers.domain.member.dto.LoginResponseDto;
import com.bugkillers.domain.member.dto.MemberJoinDto;
import com.bugkillers.domain.member.dto.MemberLoginDto;
import com.bugkillers.domain.member.entity.Member;
import com.bugkillers.domain.member.service.LoginService;
import com.bugkillers.domain.member.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;



@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/sea")
public class MemberController {

    private final SignUpService memberSignUpService;
    private final LoginService memberLoginService;


    @PostMapping("/join")
    public ResponseEntity joinMember(@RequestBody MemberJoinDto memberJoinDto){
        Member savedMember = memberSignUpService.joinMember(memberJoinDto);
        return ResponseEntity.created(URI.create("/join"+savedMember.getId())).body(savedMember);
    }


    @PostMapping("/login")
    public LoginResponseDto loginMember(@RequestBody MemberLoginDto memberLoginDto){
        LoginResponseDto responseDto = memberLoginService.logIn(memberLoginDto);
        System.out.println("TOKEN: "+responseDto.getJWtToken());
        return responseDto;
    }

    @PostMapping("/client/test")
    public String clientTest(){
        return "소비자만 접근 완료";
    }

    @PostMapping("/artist/test")
    public String artistTest(){
        return "예술가만 접근 완료";
    }

}
