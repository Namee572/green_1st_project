package com.firstproject.firstproject.domain.test.member;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Member,Long> {
    Member findByEmail(String email);
}
