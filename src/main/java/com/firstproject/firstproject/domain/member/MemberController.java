package com.firstproject.firstproject.domain.member;

import com.firstproject.firstproject.domain.member.dto.*;
import com.firstproject.firstproject.domain.member.exception.MemberException;
import com.firstproject.firstproject.domain.member.service.MemberService;
import jakarta.persistence.Table;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@Controller
// @Table(name = "member")
public class MemberController {

    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    /**
     * 회원가입
     */
    @PostMapping("/signUp")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> signUp(@Valid @RequestBody MemberSignUpDto memberSignUpDto) throws Exception {
        try {
            memberService.signUp(memberSignUpDto);
            return ResponseEntity.ok("회원가입이 성공적으로 완료되었습니다.");
        } catch (MemberException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 오류가 발생하였습니다.");
        }

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
    /*@PutMapping("/myPage/{ID}/update")
    @ResponseStatus(HttpStatus.OK)
    public void updatePassword(@Valid @RequestBody UpdatePasswordDto updatePasswordDto, @RequestHeader("email") String email) throws Exception {
        memberService.updatePassword(updatePasswordDto.checkPassword(),updatePasswordDto.toBePassword(), email);
    }
*/
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
