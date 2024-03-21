package com.firstproject.firstproject.domain.member;

import com.firstproject.firstproject.domain.member.dto.*;
import com.firstproject.firstproject.domain.member.service.MemberService;
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
     * 회원정보수정
     */
    @PutMapping("/myPage/{ID}/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateBasicInfo(@Valid @RequestBody MemberUpdateDto memberUpdateDto, @RequestHeader("email") String email) throws Exception {
        memberService.update(memberUpdateDto, email);
    }

    /**
     * 비밀번호 수정
     */
    @PutMapping("/myPage/{ID}/update")
    @ResponseStatus(HttpStatus.OK)
    public void updatePassword(@Valid @RequestBody UpdatePasswordDto updatePasswordDto, @RequestHeader("email") String email) throws Exception {
        memberService.updatePassword(updatePasswordDto.checkPassword(),updatePasswordDto.toBePassword(), email);
    }

    /**
     * 회원탈퇴
     */
    @DeleteMapping("/myPage/{ID}/delete")
    @ResponseStatus(HttpStatus.OK)
    public void withdraw(@Valid @RequestBody MemberWithdrawDto memberWithdrawDto,
                        @RequestHeader("email") String email) throws Exception {
        String checkPassword = memberWithdrawDto.checkPassword();
        memberService.withdraw(email, checkPassword);
    }

    /**
     * 내정보조회
     */
    @GetMapping("/member/myPage")
    public ResponseEntity<MemberInfoDto> getMyInfo(@RequestHeader("email") String email) throws Exception {
        MemberInfoDto info = memberService.getMyInfo(email);
        return new ResponseEntity<>(info, HttpStatus.OK);
    }
}
