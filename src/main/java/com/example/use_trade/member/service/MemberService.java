package com.example.use_trade.member.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.example.use_trade.member.domain.Member;
import com.example.use_trade.member.dto.MemberUpdateRequestDto;
import com.example.use_trade.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public void registerMember(Member member) {
        isEmailDuplicate(member.getEmail());
        member.encryptPassword(passwordEncoder);
        memberRepository.save(member);
    }

    @Transactional
    public void updateMemberInfo(Long memberId, MemberUpdateRequestDto request) throws IOException {
        Member findMember = findOne(memberId);
        findMember.updateNickname(request.getNickname());

        if (!request.getProfile().isEmpty()) {
        }

    }

    public Member findOne(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalStateException("회원이 존재하지 않습니다."));
    }

    public Member findMember(String email) {
        return memberRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalStateException("회원이 존재하지 않습니다."));
    }

    private void isEmailDuplicate(String email) {
        if (memberRepository.existsByEmail(email).isPresent()) {
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        }
    }


}
