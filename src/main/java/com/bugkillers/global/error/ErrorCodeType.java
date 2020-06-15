package com.bugkillers.global.error;

import lombok.Getter;

@Getter
public enum  ErrorCodeType {

    //Member
    MEMBER_NOT_FOUND(400, "MEMBER_001", "해당 회원을 찾을 수 없습니다."),
    WRONG_PASSWORD(400, "MEMBER_002", "비밀번호가 틀렸습니다."),
    DUPLICATED_EMAIL(400, "MEMBER_003", "중복된 이메일입니다.");

    private int status;
    private String code;
    private String message;

    ErrorCodeType(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
