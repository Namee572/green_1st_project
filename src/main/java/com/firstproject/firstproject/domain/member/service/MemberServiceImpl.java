package com.firstproject.firstproject.domain.member.service;

import com.firstproject.firstproject.domain.member.Member;
import com.firstproject.firstproject.domain.member.MemberRepository;
import com.firstproject.firstproject.domain.member.dto.MemberSignUpDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override // 회원가입 진행 메서드/ 회원가입시 컨트롤러 단에서 엔티티로 변환하여 받아오는 것이 아니라, 서비스 단에서 DTO를 엔티티로 변환/ 중복아이디 체크
    public void signUp(MemberSignUpDto memberSignUpDto) throws Exception {
        Member member = memberSignUpDto.toEntity();

        // + 비번 암호화.....

        if(memberRepository.findByEmail(memberSignUpDto.email()).isPresent()){
            throw new Exception("이미 존재하는 이메일/회원입니다.");
        }

        //회원가입 완료
        memberRepository.save(member);
    }
}
