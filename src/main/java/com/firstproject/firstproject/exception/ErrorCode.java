package com.firstproject.firstproject.exception;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
@Getter
@ToString
public enum ErrorCode {

    NOTBLACKEAMIL(HttpStatus.NOT_FOUND,"NOTBLACKEAMIL","해당하는 유저가 없습니다."),
    DUPLICATE(HttpStatus.BAD_REQUEST,"DUPLICATE","이메일 중복입니다.")

    ;

    private HttpStatus httpStatus;

    private String errorcode;

    private String message;


    ErrorCode(HttpStatus httpStatus, String errorcode, String message) {
        this.httpStatus = httpStatus;
        this.errorcode = errorcode;
        this.message = message;
    }
}
