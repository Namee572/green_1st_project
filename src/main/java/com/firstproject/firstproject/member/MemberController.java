package com.firstproject.firstproject.member;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class MemberController {

    private final MemberService userService;

    @GetMapping()
    public ResponseEntity<List<Member>> getusers(Member user){

        List<Member> list = userService.getusers(user);

        System.out.println(user);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }


    @PutMapping("{id}")
    public ResponseEntity<Member> update(@RequestParam String nickname, @RequestBody @Valid MemberDto memberDto){

        ModelMapper modelMapper = new ModelMapper();
        Member member = modelMapper.map(memberDto, Member.class);
        member.setUdate(LocalDateTime.now());
        System.out.println(member);
        Member dbmember = userService.update(nickname,member);
        System.out.println(dbmember);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dbmember);

    }

}
