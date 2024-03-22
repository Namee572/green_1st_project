package com.firstproject.firstproject.member;

import com.firstproject.firstproject.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@Table(name = "member")
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED) // ?
@AllArgsConstructor
public class Member extends BaseTimeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @Size(min = 5, max = 30)
    private String email;

    @NotBlank
    @Column(nullable = false, length = 20)
    private String name;

    @NotBlank
    @Column(nullable = false, length = 30, unique = true)
    private String nickName; // 닉네임 랜덤?

    @NotBlank
    @Column(nullable = false)
    private String password;

    @NotBlank
    @Column(nullable = false, length = 6)
    private String birth;


    public void updatePassword(String password) {
        this.password = password;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updateNickName(String nickName) {
        this.nickName = nickName;
    }

    public boolean matchPassword(String checkPassword) {
        return getPassword().equals(checkPassword);
    }
}