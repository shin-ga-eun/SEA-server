package com.bugkillers.domain.member.entity;

import lombok.Getter;

@Getter
public enum MemberRole {
    CUSTOMER("소비자"), ARTIST("예술가");

    private String role;
    MemberRole(String role){
        this.role=role;
    }

}

