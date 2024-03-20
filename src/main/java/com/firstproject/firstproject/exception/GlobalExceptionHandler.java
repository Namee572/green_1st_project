package com.firstproject.firstproject.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MemberException.class)
    public final ResponseEntity<ErrorResponse> handleUpdate(MemberException e){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorcode(e.getErrorCode().getErrorcode())
                .message(e.getErrorCode().getMessage())
                .ydate(LocalDateTime.now())
                .build();
        return ResponseEntity.status(e.getErrorCode().getHttpStatus()).body(errorResponse);
    }
}
