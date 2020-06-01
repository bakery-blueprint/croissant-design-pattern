package com.github.bakerybluprint.croissant.week_03.hs.homework.product;

public class ProductFactory {
    private ProductPrint productPrint;

    public void setProductPrint(ProductPrint productPrint) {
        this.productPrint = productPrint;
    }

    public void makePrd() {
        productPrint.setPrdCd();
        productPrint.setPrdPrc();
        productPrint.setGiftNo();
        productPrint.setStock();
    }

    public Product getProduct() {
        return productPrint.getProduct();
    }
}
