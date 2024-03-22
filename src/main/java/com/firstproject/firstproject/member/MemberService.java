package com.firstproject.firstproject.member;

import com.firstproject.firstproject.exception.ErrorCode;
import com.firstproject.firstproject.exception.MemberException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository userRepository;

    @Transactional
    public Member update(@RequestParam String nickname , Member member) {
        Member EmailUser = userRepository.findByEmailContainingAndUsernameContainingAndBirthContaining(member.getEmail(), member.getUsername(), member.getBirth());

        if (EmailUser == null) {
            System.out.println("emailUser is empty");
            throw new MemberException(ErrorCode.NOTBLACKEAMIL);
        }
        //수정한 데이터를 입력
        EmailUser.setNickname(nickname);
//        EmailUser.setPassword(user.getPassword());
//
//        System.out.println(EmailUser);
//
//        User dbuser = userRepository.save(EmailUser);

        return EmailUser;
    }


    public List<Member> getusers(Member member) {
        List<Member> list = userRepository.findAll();
        return list;
    }
}
