package com.firstproject.firstproject.exception;

import lombok.Getter;

@Getter
public class MemberException extends RuntimeException{

    private ErrorCode errorCode;
    public MemberException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
