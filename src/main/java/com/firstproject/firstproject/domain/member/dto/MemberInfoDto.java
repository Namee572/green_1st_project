package com.firstproject.firstproject.domain.member.dto;

import com.firstproject.firstproject.domain.member.Member;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberInfoDto {

    private String name;
    private String nickName;
    private String birth;
    private String password;

    @Builder
    public MemberInfoDto(Member member){
        this.name = member.getName();
        this.nickName = member.getNickName();
        this.birth = member.getBirth();
        this.password = member.getPassword();
    }
}
