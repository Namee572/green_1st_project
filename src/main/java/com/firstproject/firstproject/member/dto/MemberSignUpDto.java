package com.firstproject.firstproject.member.dto;

import com.firstproject.firstproject.member.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public record MemberSignUpDto(
        @NotBlank(message = "이메일을 입력해주세요") // F : 이메일 형식 챙겨조
        @Size(max = 50, message = "이멜 형식 아닌디?")
        String email,

        @NotBlank(message = "비밀번호를 입력해주세요") // F: 최소 8~16
        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,30}$",
                message = "비밀번호는 8~30 자리이면서 1개 이상의 알파벳, 숫자, 특수문자를 포함해야합니다.")
        String password,

        @NotBlank(message = "이름을 입력해주세요")
        @Size(max = 20, message = "본명맞냐?")
        @Pattern(regexp = "^[A-Za-z가-힣]+$", message = "사용자 이름은 한글 또는 알파벳만 입력해주세요.")
        String name,

        @NotBlank(message = "닉네임을 입력해주세요.") // F: 중복체크해주세여
        @Size(min = 2, max = 16, message = "랜덤?") // F: 최대 한글 8자, 영어 16자
        String nickName,

        @NotBlank(message = "생년월일 plz")
        @Size(min = 6, max = 6, message = "6글자 plz")
        String birth) {


    public Member toEntity() {
        return Member.builder().email(email).password(password).name(name).nickName(nickName).birth(birth).build();
    }
}

