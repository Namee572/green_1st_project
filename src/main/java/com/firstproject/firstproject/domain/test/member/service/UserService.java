package com.firstproject.firstproject.domain.test.member.service;

import com.firstproject.firstproject.domain.test.member.Member;
import com.firstproject.firstproject.domain.test.member.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean login(String email, String password) {
        Member member = userRepository.findByEmail(email);

        if (member != null && member.getPassword().equals(password)) {
            // 로그인 성공
            return true;
        } else {
            // 로그인 실패
            return false;
        }
    }
}

