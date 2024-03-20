package com.firstproject.firstproject.domain.member.service;

import com.firstproject.firstproject.domain.member.dto.MemberSignUpDto;

public interface MemberService {
    void signUp(MemberSignUpDto memberSignUpDto) throws Exception;
}