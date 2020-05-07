package com.github.bakerybluprint.croissant.week_02.dy.work;

public class Product {
    public long prdCd;      // 상품코드
    public long prdPrc;     // 상품가격
    public long giftNo;     // 사은품 코드 - 0 일 경우 사은품 없음!
    public int stock;       // 재고

    public Product(long prdCd, long prdPrc, long giftNo, int stock) {
        this.prdCd = prdCd;
        this.prdPrc = prdPrc;
        this.giftNo = giftNo;
        this.stock = stock;
    }
}