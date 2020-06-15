package com.bugkillers.domain.member.dto;

import lombok.*;

import javax.validation.constraints.Email;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberLoginDto {

    @Email(message = "이메일 형식에 맞게 작성하여주세요")
    private String email;

    private String password;

    @Builder
    public MemberLoginDto(String email, String password){
        this.email=email;
        this.password=password;
    }
}
