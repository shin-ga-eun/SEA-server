package com.bugkillers.domain.member.exception;

import com.bugkillers.global.error.BusinessLogicException;
import com.bugkillers.global.error.ErrorCodeType;

public class MemberNotFoundException extends BusinessLogicException {
    public MemberNotFoundException() {
        super(ErrorCodeType.MEMBER_NOT_FOUND);
    }
}
