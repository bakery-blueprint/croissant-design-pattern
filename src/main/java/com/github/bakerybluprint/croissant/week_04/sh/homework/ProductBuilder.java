package com.github.bakerybluprint.croissant.week_04.sh.homework;

public class ProductBuilder {

    private Product product;

    public ProductBuilder() {
        product = new Product(0, 0, 0, 0);
    }

    public static ProductBuilder start() {
        return new ProductBuilder();
    }

    public ProductBuilder setPrdCd(long prdCd) {
        product.setPrdCd(prdCd);
        return this;
    }

    public ProductBuilder setPrdPrc(long prdPrc) {
        product.setPrdPrc(prdPrc);
        return this;
    }

    public ProductBuilder setGiftNo(long giftNo) {
        product.setGiftNo(giftNo);
        return this;
    }

    public ProductBuilder setStock(int stock) {
        product.setStock(stock);
        return this;
    }

    public Product build() {
        return this.product;
    }
}
