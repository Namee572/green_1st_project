package com.firstproject.firstproject.domain.member.service;

import com.firstproject.firstproject.domain.member.Member;
import com.firstproject.firstproject.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;
    public Member login(String email, String password) throws Exception {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("아이디가 없습니다"));

        if (!member.getPassword().equals(password)) {
            throw new Exception("비밀번호가 일치하지 않습니다");
        }
        return member;
    }
}
