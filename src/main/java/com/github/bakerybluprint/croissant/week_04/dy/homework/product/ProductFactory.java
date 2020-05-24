package com.github.bakerybluprint.croissant.week_04.dy.homework.product;

public class ProductFactory {

    private ProductBuilder productBuilder;

    public void setProductBuilder(ProductBuilder product) {
        this.productBuilder = product;
    }

    public void make() {
        this.productBuilder.setPrdCd();
        this.productBuilder.setPrdPrc();
        this.productBuilder.setGiftNo();
        this.productBuilder.setStock();
    }

    public Product getProduct() {
        return this.productBuilder.getProduct();
    }
}
