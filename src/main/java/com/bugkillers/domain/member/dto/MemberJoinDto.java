package com.bugkillers.domain.member.dto;

import com.bugkillers.domain.member.entity.MemberRole;
import lombok.*;

import javax.validation.constraints.Email;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class MemberJoinDto {
    private String name;
    private String birthday;
    private String location;
    @Email(message = "이메일 형식에 맞게 작성하여주세요")
    private String email;
    private String password;
    private String phone;
    private MemberRole role;

    @Builder
    public MemberJoinDto(String name, String birthday, String location, String email, String password, String phone, MemberRole role){
        this.name=name;
        this.birthday=birthday;
        this.location=location;
        this.email=email;
        this.password=password;
        this.phone=phone;
        this.role=role;
    }
}
