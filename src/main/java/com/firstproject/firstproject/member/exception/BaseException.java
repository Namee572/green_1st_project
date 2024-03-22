package com.firstproject.firstproject.member.exception;

public abstract class BaseException extends RuntimeException{
    public abstract BaseExceptionType getExceptionType();
}
