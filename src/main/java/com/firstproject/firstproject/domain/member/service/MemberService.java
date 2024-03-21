package com.firstproject.firstproject.domain.member.service;

import com.firstproject.firstproject.domain.member.Member;
import com.firstproject.firstproject.domain.member.MemberRepository;
import com.firstproject.firstproject.domain.member.dto.MemberInfoDto;
import com.firstproject.firstproject.domain.member.dto.MemberSignUpDto;
import com.firstproject.firstproject.domain.member.dto.MemberUpdateDto;
import com.firstproject.firstproject.domain.member.exception.MemberException;
import com.firstproject.firstproject.domain.member.exception.MemberExceptionType;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원가입
     */
    public void signUp(MemberSignUpDto memberSignUpDto) throws Exception {
        Member member = memberSignUpDto.toEntity();

        if (memberRepository.findByEmail(memberSignUpDto.email()).isPresent()) {
            throw new MemberException(MemberExceptionType.ALREADY_EXIST_USERNAME);
        }
        //회원가입 완료
        memberRepository.save(member);
    }

    /**
     * 회원정보 수정
     */
    public void update(MemberUpdateDto memberUpdateDto, String email) throws Exception {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new MemberException(MemberExceptionType.NOT_FOUND_MEMBER));

        // 새로운 닉네임 설정
        member.setNickName(memberUpdateDto.nickName());

        // 회원 정보 저장
        memberRepository.save(member);
    }


    /**
     * 비밀번호 변경
     */
   public void updatePassword(String asIsPassword, String toBePassword, String email) throws Exception {

        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new MemberException(MemberExceptionType.NOT_FOUND_MEMBER));

        // 현재 비밀번호 확인
        if (!member.getPassword().equals(asIsPassword)) {
            throw new MemberException(MemberExceptionType.WRONG_PASSWORD);
        }

        // 새로운 비밀번호 설정
        member.setPassword(toBePassword);

        // 회원 정보 저장
        memberRepository.save(member);
    }

    /**
     * 회원탈퇴
     */
    public void withdraw(String email,String asIsPassword) throws Exception {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new MemberException(MemberExceptionType.NOT_FOUND_MEMBER));
        if (!member.getPassword().equals(asIsPassword)) {
            throw new MemberException(MemberExceptionType.WRONG_PASSWORD);
        }
        memberRepository.delete(member);
    }

    /**
     * 내정보 가져오기
     */
    public MemberInfoDto getMyInfo(String email) throws Exception {
        Member findMember = memberRepository.findByEmail(email)
                        .orElseThrow(() -> new MemberException(MemberExceptionType.NOT_FOUND_MEMBER));
        return new MemberInfoDto(findMember);
    }

}
