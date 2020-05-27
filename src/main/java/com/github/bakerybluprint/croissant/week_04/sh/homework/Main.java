package com.github.bakerybluprint.croissant.week_04.sh.homework;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {

        /* 방법1. ProductBuilder를 통한 Product 생성 */
        Product product = ProductBuilder.start()
                                        .setPrdCd(20200526)
                                        .setPrdPrc(29900)
                                        .setGiftNo(20200501)
                                        .setStock(999)
                                        .build();

        log.info(product.toString());
        log.info("----------------------------------------------------------------");

        /* 방법2. BluePrint를 통한 Product 생성 */
        //Factory 생성 및 Specification 설정
        ProductFactory factory = new ProductFactory();
        factory.setSpecification(new AppleSpecification());

        Product product1 = factory.makeAndGet();
        log.info(product1.toString());

    }
}
