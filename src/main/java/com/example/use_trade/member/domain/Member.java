package com.example.use_trade.member.domain;

import com.example.use_trade.interest.domain.Interest;
import com.example.use_trade.product.domain.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "email", unique = true)
    public String email;

    @Column(name = "password")
    public String password;

    @Column(name = "member_name")
    public String memberName;

    @Column(name = "nickname")
    public String nickname;

    @Column(name = "phone_number")
    public String phoneNumber;

    @Column(name = "manner_temp")
    public Integer mannerTemp = 0;

    @Column(name = "role")
    public MemberRole memberRole;

    @Column(name = "profile")
    public String profile;

    @OneToMany(mappedBy = "seller")
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Interest> interests = new ArrayList<>();

    @Builder
    public Member(Long id, String email, String password, String memberName, String nickname, String phoneNumber, MemberRole memberRole) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.memberName = memberName;
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
        this.memberRole = memberRole;
        this.profile = MemberImageInit.INIT_URL;
    }
}
