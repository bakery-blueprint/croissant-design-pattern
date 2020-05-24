package com.github.bakerybluprint.croissant.week_04.dy.homework.product;

public class Product2Builder extends ProductBuilder {

    private Product product;

    public Product2Builder() {
        this.product = new Product(0L, 0L, 0L, 0);
    }

    @Override
    public void setPrdCd() {
        product.setPrdCd(22222);
    }

    @Override
    public void setPrdPrc() {
        product.setPrdPrc(10000);
    }

    @Override
    public void setGiftNo() {
        product.setGiftNo(0);
    }

    @Override
    public void setStock() {
        product.setStock(40);
    }

    @Override
    public Product getProduct() {
        return this.product;
    }
}
