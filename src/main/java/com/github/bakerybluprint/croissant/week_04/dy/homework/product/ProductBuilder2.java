package com.github.bakerybluprint.croissant.week_04.dy.homework.product;

public class ProductBuilder2 {

    private Product product;

    private ProductBuilder2() {
        product = new Product(0L, 0L, 0L, 0);
    }

    public static ProductBuilder2 start() {
        return new ProductBuilder2();
    }

    public ProductBuilder2 setPrdCd(long prdCd) {
        product.setPrdCd(prdCd);
        return this;
    }

    public ProductBuilder2 setPrdPrc(long prdPrc) {
        product.setPrdPrc(prdPrc);
        return this;
    }

    public ProductBuilder2 setGiftNo(long giftNo) {
        product.setGiftNo(giftNo);
        return this;
    }

    public ProductBuilder2 setStock(int stock) {
        product.setStock(stock);
        return this;
    }

    public Product make() {
        return this.product;
    }
}
