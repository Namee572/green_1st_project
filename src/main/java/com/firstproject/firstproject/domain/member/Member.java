package com.firstproject.firstproject.domain.member;

import com.firstproject.firstproject.domain.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@Table(name = "member")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    @Size(min = 5,max = 30)
    private String email;

    @NotBlank
    @Column(nullable = false, length = 20)
    private String name; //실명

    @NotBlank
    @Column(nullable = false, length = 30, unique = true)
    private String nickName; // 닉네임 랜덤? 유니크?

    @NotBlank
    @Column(nullable = false)
    private String password; // 추후 보안

    @NotBlank
    @Column(nullable = false, length = 6)
    private String birth;
}