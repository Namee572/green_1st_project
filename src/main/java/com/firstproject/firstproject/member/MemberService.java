package com.firstproject.firstproject.member;


import com.firstproject.firstproject.member.dto.MemberInfoDto;
import com.firstproject.firstproject.member.dto.MemberLoginDto;
import com.firstproject.firstproject.member.dto.MemberSignUpDto;
import com.firstproject.firstproject.member.dto.MemberUpdateDto;
import com.firstproject.firstproject.member.exception.MemberException;
import com.firstproject.firstproject.member.exception.MemberExceptionType;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    private String loggedInEmail;
    private String loggedInPassword;

    /**
     * 회원가입
     */
    public void signUp(MemberSignUpDto memberSignUpDto) throws Exception {
        Member member = memberSignUpDto.toEntity();

        if (memberRepository.findByEmail(memberSignUpDto.email()).isPresent()) {
            throw new MemberException(MemberExceptionType.ALREADY_EXIST_USERNAME);
        }
//        //회원가입 완료
        memberRepository.save(member);
    }

    /**
     * 로그인
     */

    public void Login(MemberLoginDto memberLoginDto) throws Exception {
        if(memberRepository.findByEmail(memberLoginDto.email()).isEmpty()) {
            throw new MemberException(MemberExceptionType.WRONG_PASSWORD); // 이메일 틀림
        }
        else if (memberRepository.findByPassword(memberLoginDto.password()).isEmpty()) {
            throw new MemberException(MemberExceptionType.WRONG_PASSWORD); // 패스워드 틀림
        }

        this.loggedInEmail = memberLoginDto.email();
        this.loggedInPassword = memberLoginDto.password();
    }

    public String getLoggedInEmail() {
        return loggedInEmail;
    }

//    public void setLoggedInEmail(String loggedInEmail) {
//        this.loggedInEmail = loggedInEmail;
//    }
//
//    public String getLoggedInPassword() {
//        return loggedInPassword;
//    }
//
//    public void setLoggedInPassword(String loggedInPassword) {
//
//        this.loggedInPassword = loggedInPassword;
//    }

    /**
     * 회원정보 수정
     */
    public void update(MemberUpdateDto memberUpdateDto, String loggedInEmail) throws Exception {
        Member member = memberRepository.findByEmail(loggedInEmail)
                .orElseThrow(() -> new MemberException(MemberExceptionType.NOT_FOUND_MEMBER));


        // 이름 업데이트
        memberUpdateDto.name().ifPresent(name -> member.updateName(name));

        // 닉네임 업데이트
        memberUpdateDto.nickName().ifPresent(nickName -> member.updateNickName(nickName));

        // 회원 정보 저장
        memberRepository.save(member);
    }


    /**
     * 비밀번호 변경
     */
   public void updatePassword(String asIsPassword, String toBePassword, String loggedInEmail) throws Exception {

        Member member = memberRepository.findByEmail(loggedInEmail)
                .orElseThrow(() -> new MemberException(MemberExceptionType.NOT_FOUND_MEMBER));

             if (!member.matchPassword(asIsPassword)) {
             throw new MemberException(MemberExceptionType.WRONG_PASSWORD);
            }

        // 새로운 비밀번호 설정
        member.updatePassword(toBePassword);

        // 회원 정보 저장
        memberRepository.save(member);
    }

    /**
     * 회원탈퇴
     */
    public void withdraw(String checkPassword, String loggedInEmail) throws Exception {
        Member member = memberRepository.findByEmail(loggedInEmail)
                .orElseThrow(() -> new MemberException(MemberExceptionType.NOT_FOUND_MEMBER));
        if (!member.matchPassword(checkPassword)) {
            throw new MemberException(MemberExceptionType.WRONG_PASSWORD);
        }
        memberRepository.delete(member);
    }

    /**
     * 내정보 가져오기
     */
    public MemberInfoDto getMyInfo() throws Exception {
        Member findMember = memberRepository.findByEmail(loggedInEmail)
                        .orElseThrow(() -> new MemberException(MemberExceptionType.NOT_FOUND_MEMBER));
        return new MemberInfoDto(findMember);
    }


    // 로그아웃 메서드
    public void logout() {
        // 로그인 정보 초기화
        this.loggedInEmail = null;
        this.loggedInPassword = null;
    }

}

//  준재님
//@Transactional
//public Member update(@RequestParam String nickname , Member user) {
//    Member EmailUser = userRepository.findByEmailContainingAndUsernameContainingAndNumberContaining(user.getEmail(), user.getUsername(), user.getNumber());
//
//    if (EmailUser == null) {
//        System.out.println("emailUser is empty");
//        throw new MemberException(ErrorCode.NOTBLACKEAMIL);
//    }
//    //수정한 데이터를 입력
//    EmailUser.setNickname(nickname);
////        EmailUser.setPassword(user.getPassword());
////
////        System.out.println(EmailUser);
////
////        User dbuser = userRepository.save(EmailUser);
//
//    return EmailUser;
//}
//
//
//public List<Member> getusers(Member user) {
//    List<Member> list = userRepository.findAll();
//    return list;
//}
