package com.example.use_trade.product.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

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
}
