package com.zerobase.fastlms.member.exception;

public class LoginInfoNotExistException extends RuntimeException {
    public LoginInfoNotExistException(String error) {
        super(error);
    }

}
