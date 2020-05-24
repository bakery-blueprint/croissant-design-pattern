package com.github.bakerybluprint.croissant.week_04.dy.homework.product;

public class Product {
    private long prdCd;      // 상품코드
    private long prdPrc;     // 상품가격
    private long giftNo;     // 사은품 코드 - 0 일 경우 사은품 없음!
    private int stock;       // 재고

    public Product(long prdCd, long prdPrc, long giftNo, int stock) {
        this.prdCd = prdCd;
        this.prdPrc = prdPrc;
        this.giftNo = giftNo;
        this.stock = stock;
    }

    public long getPrdCd() {
        return prdCd;
    }

    public void setPrdCd(long prdCd) {
        this.prdCd = prdCd;
    }

    public long getPrdPrc() {
        return prdPrc;
    }

    public void setPrdPrc(long prdPrc) {
        this.prdPrc = prdPrc;
    }

    public long getGiftNo() {
        return giftNo;
    }

    public void setGiftNo(long giftNo) {
        this.giftNo = giftNo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}


