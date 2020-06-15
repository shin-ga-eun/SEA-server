package com.bugkillers.domain.member.exception;

import com.bugkillers.global.error.BusinessLogicException;
import com.bugkillers.global.error.ErrorCodeType;

public class DuplicatedEmailException extends BusinessLogicException {
    public DuplicatedEmailException() {
        super(ErrorCodeType.DUPLICATED_EMAIL);
    }
}
