package com.github.bakerybluprint.croissant.week_04.sh.homework;

public class ProductFactory {

    private Specification specification;

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public Product makeAndGet() {
        //make
        specification.setPrdCd();
        specification.setPrdPrc();
        specification.setGiftNo();
        specification.setStock();
        //get
        return specification.getProduct();
    }
}
