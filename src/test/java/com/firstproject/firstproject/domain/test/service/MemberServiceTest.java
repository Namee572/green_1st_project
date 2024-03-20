//package com.firstproject.firstproject.domain.member.service;
//
//import com.firstproject.firstproject.domain.member.Member;
//import com.firstproject.firstproject.domain.member.dto.MemberSignUpDto;
//import com.firstproject.firstproject.domain.member.repository.MemberRepository;
//import jakarta.persistence.EntityManager;
//import jakarta.transaction.Transactional;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//@Transactional
//class MemberServiceTest {
//
//    @Autowired EntityManager em;
//    @Autowired
//    MemberRepository memberRepository;
//    @Autowired
//    MemberService memberService;
//
//    String PASSWORD = "password";
//
//   private void clear(){
//       em.flush();
//       em.clear();
//   }
//
//   private MemberSignUpDto makeMemberSignUpDto() {
//       return new MemberSignUpDto("email",PASSWORD,"name","nickName","phoneNumber");
//   }
//
//   private MemberSignUpDto setMember() throws Exception {
//       MemberSignUpDto memberSignUpDto = makeMemberSignUpDto();
//       memberService.signUp(memberSignUpDto);
//       clear();
//
//       return memberSignUpDto;
//   }
//
//    /*
//     * 회원가입
//     *    회원가입 시 아이디, 비밀번호, 이름, 별명, 폰번호를 입력하지 않으면 오류
//     *    이미 존재하는 아이디가 있으면 오류
//     */
//    @Test
//    public void 회원가입_성공() throws Exception {
//        //given
//        MemberSignUpDto memberSignUpDto = makeMemberSignUpDto();
//
//        //when
//        memberService.signUp(memberSignUpDto);
//        clear();
//
//        //then
//        Member member = memberRepository.findByEmail(memberSignUpDto.email()).orElseThrow(() -> new MemberException(MemberExceptionType.NOT_FOUND_MEMBER));
//        assertThat(member.getId()).isNotNull();
//        assertThat(member.getEmail()).isEqualTo(memberSignUpDto.email());
//        assertThat(member.getName()).isEqualTo(memberSignUpDto.name());
//        assertThat(member.getNickName()).isEqualTo(memberSignUpDto.nickName());
//        assertThat(member.getPhoneNumber()).isEqualTo(memberSignUpDto.phoneNumber());
//    }
//
//    public void 회원가입_실패_원인_아이디중복() throws Exception {
//        //given
//        MemberSignUpDto memberSignUpDto = makeMemberSignUpDto();
//        memberService.signUp(memberSignUpDto);
//        clear();
//
//        //when, then
//        assertThat(assertThrows(MemberException.class, () -> memberService.signUp(memberSignUpDto)).getExceptionType()).isEqualTo(MemberExceptionType.ALREADY_EXIST_USERNAME);
//
//    }
//
//
//    @Test
//    public void 회원가입_실패_입력하지않은_필드가있으면_오류() throws Exception {
//        //given
//        MemberSignUpDto memberSignUpDto1 = new MemberSignUpDto(null,passwordEncoder.encode(PASSWORD),"name","nickNAme",22);
//        MemberSignUpDto memberSignUpDto2 = new MemberSignUpDto("username",null,"name","nickNAme",22);
//        MemberSignUpDto memberSignUpDto3 = new MemberSignUpDto("username",passwordEncoder.encode(PASSWORD),null,"nickNAme",22);
//        MemberSignUpDto memberSignUpDto4 = new MemberSignUpDto("username",passwordEncoder.encode(PASSWORD),"name",null,22);
//        MemberSignUpDto memberSignUpDto5 = new MemberSignUpDto("username",passwordEncoder.encode(PASSWORD),"name","nickNAme",null);
//
//
//        //when, then
//
//        assertThrows(Exception.class, () -> memberService.signUp(memberSignUpDto1));
//
//        assertThrows(Exception.class, () -> memberService.signUp(memberSignUpDto2));
//
//        assertThrows(Exception.class, () -> memberService.signUp(memberSignUpDto3));
//
//        assertThrows(Exception.class, () -> memberService.signUp(memberSignUpDto4));
//
//        assertThrows(Exception.class, () -> memberService.signUp(memberSignUpDto5));
//    }
//
//}
