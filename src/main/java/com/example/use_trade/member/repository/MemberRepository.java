package com.example.use_trade.member.repository;

import com.example.use_trade.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);
    Optional<Object> existsByEmail(String email);
}
