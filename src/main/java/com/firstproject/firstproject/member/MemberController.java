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


    @PutMapping()
    public ResponseEntity<Member> update(@RequestParam String nickname, @RequestBody @Valid MemberDto userDto){

        ModelMapper modelMapper = new ModelMapper();
        Member user = modelMapper.map(userDto, Member.class);
        user.setUdate(LocalDateTime.now());
        System.out.println(user);
        Member dbuser = userService.update(nickname,user);
        System.out.println(dbuser);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dbuser);

    }

}
