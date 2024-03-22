package com.firstproject.firstproject.member.dto;


import java.util.Optional;


public record MemberUpdateDto(Optional<String> name, Optional<String> nickName) {

}