package com.bugkillers.service.member;

import com.bugkillers.domain.dto.member.SignUpDto;
import com.bugkillers.domain.entity.Member;
import com.bugkillers.repository.member.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    final MemberRepository memberRepository;

    public SignUpService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void signUp(SignUpDto signUpDto) {
        Member member= new Member();

        member.setPlatform_type(signUpDto.getPlatform_type());
        member.setAccess_token(signUpDto.getAccess_token());
        member.setEmail(signUpDto.getEmail());
        member.setPassword(signUpDto.getPassword());
        member.setRole(signUpDto.getRole());
        member.setName(signUpDto.getName());
        member.setImage(signUpDto.getImage());
        member.setProfile(signUpDto.getProfile());

        memberRepository.save(member);
    }
}
