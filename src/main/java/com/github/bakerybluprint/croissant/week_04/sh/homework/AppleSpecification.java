package com.github.bakerybluprint.croissant.week_04.sh.homework;

public class AppleSpecification extends Specification {

    private Product product;

    public AppleSpecification() {
        product = new Product(0,0,0,0, "Apple", "United States");
    }

    @Override
    void setPrdCd() {
        product.setPrdCd(1234);
    }

    @Override
    void setPrdPrc() {
        product.setPrdPrc(99000);
    }

    @Override
    void setGiftNo() {
        product.setGiftNo(1234);
    }

    @Override
    void setStock() {
        product.setGiftNo(9999);
    }

    @Override
    Product getProduct() {
        return product;
    }
}
