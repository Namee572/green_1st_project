package com.firstproject.firstproject.domain.test.member.service;

import com.firstproject.firstproject.domain.test.member.dto.MemberSignUpDto;

public interface MemberService {
    void signUp(MemberSignUpDto memberSignUpDto) throws Exception;
}