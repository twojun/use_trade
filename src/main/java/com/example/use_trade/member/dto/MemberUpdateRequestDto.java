package com.example.use_trade.member.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
public class MemberUpdateRequestDto {

    private MultipartFile profile;
    private String nickname;

    @Builder
    public MemberUpdateRequestDto(MultipartFile profile, String nickname) {
        this.profile = profile;
        this.nickname = nickname;
    }
}
