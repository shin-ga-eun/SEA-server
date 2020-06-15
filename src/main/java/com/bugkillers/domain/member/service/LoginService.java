package com.bugkillers.domain.member.service;


import com.bugkillers.domain.member.dto.LoginResponseDto;
import com.bugkillers.domain.member.dto.MemberLoginDto;
import com.bugkillers.domain.member.entity.Member;
import com.bugkillers.domain.member.exception.MemberNotFoundException;
import com.bugkillers.domain.member.exception.WrongPasswordException;
import com.bugkillers.domain.member.repository.MemberRepository;
import com.bugkillers.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public LoginResponseDto logIn(MemberLoginDto memberLoginDto){
        Member member=memberRepository.findByEmail(memberLoginDto.getEmail());

        if(member == null){
            throw new MemberNotFoundException();
        }

        if(!passwordEncoder.matches(memberLoginDto.getPassword(),member.getPassword())){
            throw new WrongPasswordException();
        }

        LoginResponseDto loginResponseDto= new LoginResponseDto();
        loginResponseDto.setJWtToken(jwtTokenProvider.createToken(member.getEmail(),member.getRole()));
        loginResponseDto.setRole(member.getRole().toString());

        return loginResponseDto;

//
//        return LoginResponseDto.builder()
//                .JWtToken(jwtTokenProvider.createToken(member.getEmail(), member.getRole()))
//                .role(member.getRole().toString()).build();
    }
}
