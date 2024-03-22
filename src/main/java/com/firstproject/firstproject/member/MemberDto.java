package com.firstproject.firstproject.member;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MemberDto {
    private Long id;
    @Size(min=5, max = 50)
    @NotBlank
    private String email;
    @NotBlank
    private String nickname;
    @NotBlank
    private String password;
    @NotBlank
    private String username;
    @NotBlank
    private String birth;
}
