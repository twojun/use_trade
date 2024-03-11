package com.example.use_trade.member.dto;

import com.example.use_trade.member.domain.Member;
import com.example.use_trade.member.domain.MemberRole;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberJoinRequestDto {

    @NotEmpty(message = "이메일은 필수 입력 사항입니다.")
    private String email;

    @NotEmpty(message = "비밀번호는 필수 입력 사항입니다.")
    private String password;

    @NotEmpty(message = "이름은 필수 입력 사항입니다.")
    private String memberName;

    @NotEmpty(message = "휴대폰 번호는 필수 입력 사항입니다.")
    private String phoneNumber;

    @NotEmpty(message = "닉네임은 필수 입력 사항입니다.")
    private String nickname;

    @Builder
    public MemberJoinRequestDto(String email, String password, String memberName, String phoneNumber, String nickname) {
        this.email = email;
        this.password = password;
        this.memberName = memberName;
        this.phoneNumber = phoneNumber;
        this.nickname = nickname;
    }

    // 엔티티로 변환
    public Member toEntity() {
        return Member.builder()
                .email(email)
                .password(password)
                .memberName(memberName)
                .phoneNumber(phoneNumber)
                .nickname(nickname)
                .memberRole(MemberRole.ROLE_USER)
                .build();
    }
}
