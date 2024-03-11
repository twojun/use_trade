package com.example.use_trade.member.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberLoginRequestDto {

    @NotEmpty(message = "이메일을 입력해 주세요.")
    private String email;

    @NotEmpty(message = "비밀번호를 입력해 주세요.")
    private String password;

    @Builder
    public MemberLoginRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
