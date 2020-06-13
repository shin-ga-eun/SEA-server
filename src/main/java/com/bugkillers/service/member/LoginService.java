package com.bugkillers.service.member;

import com.bugkillers.domain.dto.member.LoginDto;
import com.bugkillers.domain.entity.Member;
import com.bugkillers.repository.member.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    final MemberRepository memberRepository;

    public LoginService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public String login(LoginDto loginDto) {

        Member member = memberRepository.findByEmail(loginDto.getEmail());

        if (member.getEmail().equals(loginDto.getEmail())) {
            if (member.getPassword().equals(loginDto.getPassword())) {
                return member.getName();
            }
        }

        return "fail";

    }
}
