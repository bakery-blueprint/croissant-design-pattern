package com.github.bakerybluprint.croissant.week_04.dy.homework.Pay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreditCard implements Payment {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreditCard.class);

    @Override
    public void pay(long prc) {
        LOGGER.info(prc + "원 신용카드로 결제");
    }
}
