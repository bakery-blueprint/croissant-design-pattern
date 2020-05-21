package com.github.bakerybluprint.croissant.week_03.dy.homework.Pay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Point implements Payment {

    private static final Logger LOGGER = LoggerFactory.getLogger(Point.class);

    @Override
    public void pay(long prc) {
        LOGGER.info(prc + "원 포인트로 결제");
    }
}
