package com.example.use_trade.member.domain;

import com.example.use_trade.interest.domain.Interest;
import com.example.use_trade.product.domain.Product;
import com.example.use_trade.product.domain.ProductStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    // 닉네임 업데이트
    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }

    // 프로필 업데이트
    public void updateProfile(String profile) {
        this.profile = profile;
    }

    // 비밀번호 암호화
    public Member encryptPassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
        return this;
    }

    // 관심 리스트에서 상품 정보 추출
    public List<Product> getProductByInterest() {
        return this.getInterests().stream()
                .map(item -> item.getProduct())
                .collect(Collectors.toList());
    }

    // 관심 목록 상태별 상품 정보 추출
    public List<Product> getInterestStatus(ProductStatus productStatus) {
        if (productStatus == null) {
            return getProductByInterest();
        }
        return interests.stream()
                .filter(item -> item.getProduct().getStatus() == productStatus)
                .map(item -> item.getProduct())
                .collect(Collectors.toList());
    }

    // 상품 상태별 상품 정보 추출
    public List<Product> getProductByStatus(ProductStatus productStatus) {
        if (productStatus == null) {
            return products;
        }
        return products.stream()
                .filter(item -> item.getStatus() == productStatus)
                .collect(Collectors.toList());
    }
}
