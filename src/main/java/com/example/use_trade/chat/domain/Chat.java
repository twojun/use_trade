package com.example.use_trade.chat.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "chat")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chat {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private Long id;

    @Column(name = "type")
    private ChatType type;

    @Column(name = "profile")
    private String profile;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "content")
    private String content;

}
