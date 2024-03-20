package com.firstproject.firstproject.domain.test.member.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {

    public LoginResponse(boolean succces, String mesage) {
        this.succces = succces;
        this.mesage = mesage;
    }

    private boolean succces;
    private String mesage;

}
