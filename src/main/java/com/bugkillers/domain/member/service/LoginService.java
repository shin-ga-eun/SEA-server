package com.bugkillers.domain.member.service;


import com.bugkillers.domain.member.dto.MemberLoginDto;
import com.bugkillers.domain.member.entity.Member;
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

    public String logIn(MemberLoginDto memberLoginDto){
        Member member=memberRepository.findByEmail(memberLoginDto.getEmail());

        if(!passwordEncoder.matches(memberLoginDto.getPassword(),member.getPassword())){
            throw new WrongPasswordException();
        }

        return jwtTokenProvider.createToken(member.getEmail(),member.getRole());
    }
}
