package com.firstproject.firstproject.domain.member.dto;

import com.firstproject.firstproject.domain.member.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record MemberSignUpDto(
        @NotBlank(message = "이메일을 입력해주세요")
        @Size(max = 255, message = "길이초과")
        String email,

        @NotBlank(message = "비밀번호를 입력해주세요")
        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,30}$",
                message = "비밀번호는 8~30 자리이면서 1개 이상의 알파벳, 숫자, 특수문자를 포함해야합니다.")
        String password,

        @NotBlank(message = "이름을 입력해주세요")
        @Size(min = 2, message = "본명이냐?")
        @Pattern(regexp = "^[A-Za-z가-힣]+$", message = "사용자 이름은 한글 또는 알파벳만 입력해주세요.")
        String name,

        @NotBlank(message = "닉네임을 입력해주세요.")
        @Size(min = 2, message = "랜덤?")
        @NotBlank String nickName,

        @NotBlank(message = "생년월일 8자? 달력?")
        String birth) {

    public Member toEntity() {
        return Member.builder()
                .email(email)
                .name(name)
                .password(password)
                .nickName(nickName)
                .birth(birth)
                .build();
    }
}

