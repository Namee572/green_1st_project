package com.firstproject.firstproject.member;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmailContainingAndUsernameContainingAndNumberContaining(String email, String username, String number);
}
