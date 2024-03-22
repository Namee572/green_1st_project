package com.firstproject.firstproject.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
    Optional<Member> findByPassword(String password);
    //Optional<Member> findByEmailAndPassword(String email, String password);
}

// 준재님
//@Repository
//public interface MemberRepository extends JpaRepository<Member, Long> {
//
//    Member findByEmailContainingAndUsernameContainingAndNumberContaining(String email, String username, String number);
//}