package com.firstproject.firstproject.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record MemberLoginDto(@NotBlank(message = "이메일을 입력해주세요") // F : 이메일 형식 챙겨조
                             @Size(max = 50, message = "이멜 형식 아닌디?")
                             String email,

                             @NotBlank(message = "비밀번호를 입력해주세요") // F: 최소 8~16
                             @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,30}$",
                                     message = "비밀번호는 8~30 자리이면서 1개 이상의 알파벳, 숫자, 특수문자를 포함해야합니다.")
                             String password) {
}
