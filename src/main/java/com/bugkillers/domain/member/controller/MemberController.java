package com.bugkillers.domain.member.controller;

import com.bugkillers.domain.member.dto.MemberJoinDto;
import com.bugkillers.domain.member.dto.MemberLoginDto;
import com.bugkillers.domain.member.entity.Member;
import com.bugkillers.domain.member.service.LoginService;
import com.bugkillers.domain.member.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;


@RequiredArgsConstructor
@RestController
public class MemberController {

    private final SignUpService memberSignUpService;
    private final LoginService memberLoginService;



    @PostMapping("/join")
    public ResponseEntity joinMember(@RequestBody MemberJoinDto memberJoinDto){
        Member savedMember = memberSignUpService.joinMember(memberJoinDto);
        return ResponseEntity.created(URI.create("/join"+savedMember.getId())).body(savedMember);
    }


    @PostMapping("/login")
    public String loginMember(@RequestBody MemberLoginDto memberLoginDto){
        String JwtToken = memberLoginService.logIn(memberLoginDto);
        return JwtToken;
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
