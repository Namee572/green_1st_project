package com.firstproject.firstproject.member.dto;

import com.firstproject.firstproject.member.Member;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberInfoDto {

    private String email;
    private String name;
    private String nickName;
    private String birth;
    private String password;

    @Builder
    public MemberInfoDto(Member member){
        this.email = member.getEmail();
        this.name = member.getName();
        this.nickName = member.getNickName();
        this.birth = member.getBirth();
        this.password = member.getPassword();
    }
}
