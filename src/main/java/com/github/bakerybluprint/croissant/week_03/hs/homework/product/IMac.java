package com.github.bakerybluprint.croissant.week_03.hs.homework.product;

public class IMac extends ProductPrint{
    private Product product;

    public IMac() {
        this.product = new Product(0, 0, 0, 0);
    }

    @Override
    public void setPrdCd() {
        product.setPrdCd(222222);
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
        return product;
    }
}
