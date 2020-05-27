package com.github.bakerybluprint.croissant.week_04.dy.homework.product;

public class Product1Builder extends ProductBuilder {

    private Product product;

    public Product1Builder() {
        this.product = new Product(0L, 0L, 0L, 0);
    }

    @Override
    public void setPrdCd() {
        product.setPrdCd(11111);
    }

    @Override
    public void setPrdPrc() {
        product.setPrdPrc(20000);
    }

    @Override
    public void setGiftNo() {
        product.setGiftNo(12345);
    }

    @Override
    public void setStock() {
        product.setStock(10);
    }

    @Override
    public Product getProduct() {
        return this.product;
    }
}
