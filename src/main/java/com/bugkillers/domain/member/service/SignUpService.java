package com.bugkillers.domain.member.service;


import com.bugkillers.domain.member.dto.IsMemberDto;
import com.bugkillers.domain.member.dto.LoginResponseDto;
import com.bugkillers.domain.member.dto.MemberJoinDto;
import com.bugkillers.domain.member.entity.Member;
import com.bugkillers.domain.member.exception.DuplicatedEmailException;
import com.bugkillers.domain.member.repository.MemberRepository;
import com.bugkillers.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public Member joinMember(MemberJoinDto memberJoinDto) {

        if (memberRepository.existsByEmail(memberJoinDto.getEmail())) {
            throw new DuplicatedEmailException();
        }

        memberJoinDto.setPassword(passwordEncoder.encode(memberJoinDto.getPassword()));

        Member savedMember = memberRepository.save(Member.builder()
                .name(memberJoinDto.getName())
                .birthday(memberJoinDto.getBirthday())
                .location(memberJoinDto.getLocation())
                .email(memberJoinDto.getEmail())
                .password(memberJoinDto.getPassword())
                .phone(memberJoinDto.getPhone())
                .role(memberJoinDto.getRole()).build());

        return savedMember;
    }

    public LoginResponseDto isMember(IsMemberDto isMemberDto) {
        String email = isMemberDto.getEmail();
        Member member = memberRepository.findByEmail(email);

        if (member == null) {
            return LoginResponseDto.builder()
                    .token("None")
                    .role("None").build();
        }

        return LoginResponseDto.builder()
                .token(jwtTokenProvider.createToken(member.getEmail(), member.getRole()))
                .role(member.getRole().toString()).build();
    }
}
