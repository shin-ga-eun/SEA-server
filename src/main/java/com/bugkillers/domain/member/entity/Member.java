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

    @Column(length = 800, nullable = false)
    private String birthday;

    @Column(length = 100, nullable = false)
    private String phone;

    @Column(length = 800, nullable = false)
    private String location;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;


    @Enumerated(value = EnumType.STRING)
    private MemberRole role; //소비자 or 예술가

    @Builder
    public Member(String name, String birthday,String phone,String location,String email,String password,MemberRole role){
        this.name=name;
        this.birthday=birthday;
        this.phone=phone;
        this.location=location;
        this.email=email;
        this.password=password;
        this.role=role;
    }
}
