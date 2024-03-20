package com.firstproject.firstproject.domain.member;

import com.firstproject.firstproject.domain.BaseTimeEntity;
import jakarta.persistence.*;
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
public class Member extends BaseTimeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String email;

    private String password;

    @Column(nullable = false, length = 30)
    private String name; //실명

    @Column(nullable = false, length = 30)
    private String nickName; // 닉네임 랜덤?

    @Column(nullable = false, length = 8)
    private String birth; // ?
}