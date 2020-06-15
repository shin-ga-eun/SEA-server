package com.bugkillers.domain.member.entity;

import lombok.*;
import javax.persistence.*;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String birthDay;

    @Column(length = 100, nullable = false)
    private String phone;

    @Column(length = 100, nullable = false)
    private String address;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;


    @Enumerated(value = EnumType.STRING)
    private MemberRole role; //소비자 or 예술가

    @Builder
    public Member(String name, String birthDay,String phone,String address,String email,String password,MemberRole role){
        this.name=name;
        this.birthDay=birthDay;
        this.phone=phone;
        this.address=address;
        this.email=email;
        this.password=password;
        this.role=role;
    }
}
