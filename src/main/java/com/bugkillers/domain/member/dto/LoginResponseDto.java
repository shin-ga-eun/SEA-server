package com.bugkillers.domain.member.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
public class LoginResponseDto {
    private String JWtToken;
    private String role;

    @Builder
    public LoginResponseDto(String JWtToken, String role){
        this.JWtToken=JWtToken;
        this.role=role;
    }

}
