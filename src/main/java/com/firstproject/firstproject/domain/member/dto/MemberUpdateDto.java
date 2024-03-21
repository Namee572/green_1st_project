package com.firstproject.firstproject.domain.member.dto;


import jakarta.validation.constraints.NotBlank;

public record MemberUpdateDto(
        @NotBlank(message = "닉네임을 입력해주세요")
         String nickName) {
}