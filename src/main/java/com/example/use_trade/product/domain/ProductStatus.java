package com.example.use_trade.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductStatus {

    TRADE("판매 중"),
    COMPLETED("거래 완료"),
    RESERVATION("예약 중");

    private String value;
}
