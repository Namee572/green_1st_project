package com.firstproject.firstproject.domain.test.member;

import com.firstproject.firstproject.domain.test.member.dto.LoginRequest;
import com.firstproject.firstproject.domain.test.member.dto.LoginResponse;
import com.firstproject.firstproject.domain.test.member.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    private UserService userService;



    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        boolean success = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
        if (success) {
            return new LoginResponse(true, "로그인 성공!");
        } else {
            return new LoginResponse(false, "로그인 실패!");
        }
    }
    /*@PostMapping("/register")
    public String registerUser(@RequestBody UserRegistrationRequest userRequest) {
        boolean success = userService.registerUser(userRequest.getUsername(), userRequest.getPassword());
        if (success) {
            return "회원 가입 성공!";
        } else {
            return "회원 가입 실패! 이미 존재하는 사용자입니다.";
        }
    */}

