package com.firstproject.firstproject.member;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Builder
@Table(name = "users")
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    @Size(min = 5,max = 15)
    private String email;
    @NotBlank
    @Column(nullable = false)
    private String nickname;
    @NotBlank
    @Column(nullable = false)
    private String username;
    @NotBlank
    @Column(nullable = false)
    private String password;
    @NotBlank
    @Column(nullable = false)
    private String number;

    @CreatedDate
    private LocalDateTime cdate;

    @LastModifiedDate
    private LocalDateTime udate;
}
