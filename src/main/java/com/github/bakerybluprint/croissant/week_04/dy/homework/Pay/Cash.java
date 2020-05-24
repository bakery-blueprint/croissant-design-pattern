package com.github.bakerybluprint.croissant.week_04.dy.homework.Pay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cash implements Payment {

    private static final Logger LOGGER = LoggerFactory.getLogger(Cash.class);

    @Override
    public void pay(long prc) {
        LOGGER.info(prc + "원 현금 결제");
    }
}
