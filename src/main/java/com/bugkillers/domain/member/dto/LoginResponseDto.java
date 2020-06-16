package com.bugkillers.domain.member.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class LoginResponseDto {
    private String token;
    private String role;

    @Builder
    public LoginResponseDto(String token, String role){
        this.token=token;
        this.role=role;
    }

}
