package com.firstproject.firstproject.domain.member.exception;

import com.firstproject.firstproject.global.exception.BaseException;
import com.firstproject.firstproject.global.exception.BaseExceptionType;

public class MemberException extends BaseException {
    private BaseExceptionType exceptionType;


    public MemberException(BaseExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    @Override
    public BaseExceptionType getExceptionType() {
        return exceptionType;
    }
}