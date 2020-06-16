package com.bugkillers.domain.member.dto;

import lombok.*;

import javax.validation.constraints.Email;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberLoginDto {

    private String email;

    private String password;

    @Builder
    public MemberLoginDto(String email, String password){
        this.email=email;
        this.password=password;
    }
}
