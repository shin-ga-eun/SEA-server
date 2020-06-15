package com.bugkillers.domain.member.exception;

import com.bugkillers.global.error.BusinessLogicException;
import com.bugkillers.global.error.ErrorCodeType;

public class WrongPasswordException extends BusinessLogicException {
    public WrongPasswordException() {
        super(ErrorCodeType.WRONG_PASSWORD);
    }
}
