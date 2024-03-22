package com.firstproject.firstproject.member;


import com.firstproject.firstproject.member.dto.*;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원가입
     */
    @PostMapping("/join")
    @ResponseStatus(HttpStatus.OK)
    public void signUp(@Valid @RequestBody MemberSignUpDto memberSignUpDto) throws Exception {
        memberService.signUp(memberSignUpDto);
    }

    /**
     * 로그인
     */
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public void login(@Valid @RequestBody MemberLoginDto memberLoginDto) throws Exception {
        memberService.Login(memberLoginDto);
    }

    /**
     * 로그아웃
     */
    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.OK)
    public void logout() {
        memberService.logout();
    }
    /**
     * 회원정보수정
     */
    @PutMapping("/myPage/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateBasicInfo(@Valid @RequestBody MemberUpdateDto memberUpdateDto) throws Exception {
        memberService.update(memberUpdateDto, memberService.getLoggedInEmail());

    }

    /**
     * 비밀번호 수정
     */
    @PutMapping("/myPage/update/password")
    @ResponseStatus(HttpStatus.OK)
   public void updatePassword(@Valid @RequestBody UpdatePasswordDto updatePasswordDto) throws Exception {
        memberService.updatePassword(updatePasswordDto.checkPassword(), updatePasswordDto.toBePassword(), memberService.getLoggedInEmail());
    }

    /**
     * 회원탈퇴
     */
    @DeleteMapping("/myPage/delete")
    @ResponseStatus(HttpStatus.OK)
    public void withdraw(@Valid @RequestBody MemberWithdrawDto memberWithdrawDto) throws Exception {
        memberService.withdraw(memberWithdrawDto.checkPassword(), memberService.getLoggedInEmail());
    }

    /**
     * 내정보조회
     */
   @GetMapping("/myPage")
    public ResponseEntity getMyInfo(HttpServletResponse response) throws Exception {

        MemberInfoDto info = memberService.getMyInfo();
        return new ResponseEntity(info, HttpStatus.OK);
    }

}

// 준재님
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("users")
//public class MemberController {
//
//    private final MemberService userService;
//
//    @GetMapping()
//    public ResponseEntity<List<Member>> getusers(Member user){
//
//        List<Member> list = userService.getusers(user);
//
//        System.out.println(user);
//        return ResponseEntity.status(HttpStatus.OK).body(list);
//    }
//
//
//    @PutMapping()
//    public ResponseEntity<Member> update(@RequestParam String nickname, @RequestBody @Valid MemberDto userDto){
//
//        ModelMapper modelMapper = new ModelMapper();
//        Member user = modelMapper.map(userDto, Member.class);
//        user.setUdate(LocalDateTime.now());
//        System.out.println(user);
//        Member dbuser = userService.update(nickname,user);
//        System.out.println(dbuser);
//
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dbuser);
//
//    }
//
//}