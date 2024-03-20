package com.firstproject.firstproject.domain.test.member;

import com.firstproject.firstproject.domain.test.member.dto.MemberSignUpDto;
import com.firstproject.firstproject.domain.test.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController // 문자열을 response의 Body에 작성하여 전송
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signUp")
    @ResponseStatus(HttpStatus.OK) // @ResponseStatus(HttpStatus.OK)는 항상 상태코드를 200으로 반환
    public void signUp(@Valid @RequestBody MemberSignUpDto memberSignUpDto) throws Exception {
        memberService.signUp(memberSignUpDto);
    }
}
