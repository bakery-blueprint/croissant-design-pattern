package com.github.bakerybluprint.croissant.week_03.hs.homework.product;

public class MacBook extends ProductPrint{

    private Product product;

    public MacBook() {
        this.product = new Product(0, 0, 0, 0);
    }

    @Override
    public void setPrdCd() {
        product.setPrdCd(111111);
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
        return product;
    }
}
