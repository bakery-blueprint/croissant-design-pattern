package com.github.bakerybluprint.croissant.week_04.dy.homework.product;

public abstract class ProductBuilder {

    abstract public void setPrdCd();
    abstract public void setPrdPrc();
    abstract public void setGiftNo();
    abstract public void setStock();

    public abstract Product getProduct();
}
