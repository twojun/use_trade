package com.example.use_trade.product.domain;

import com.example.use_trade.chat.domain.ChatRoom;
import com.example.use_trade.interest.domain.Interest;
import com.example.use_trade.member.domain.Member;
import com.example.use_trade.product_image.domain.ProductImage;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "category")
    private String category;

    @Column(name = "place")
    private String place;

    @Column(name = "price")
    private Integer price;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private ProductStatus state;

    @Column(name = "interest_count")
    private Integer interestCount;

    @Column(name = "chatting_count")
    private Integer chattingCount;

    @Column(name = "date")
    private ZonedDateTime date;

    @Column(name = "content")
    private String content;

    @Column(name = "thumbnail")
    private String thumbnail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member seller;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<ChatRoom> chatRooms = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Interest> interests = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<ProductImage> productImages = new ArrayList<>();
}
