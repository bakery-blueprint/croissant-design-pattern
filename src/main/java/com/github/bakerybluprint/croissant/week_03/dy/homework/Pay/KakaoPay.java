package com.github.bakerybluprint.croissant.week_03.dy.homework.Pay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KakaoPay implements Payment {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreditCard.class);

    @Override
    public void pay(long prc) {
        LOGGER.info(prc + "원 카카오페이로 결제");
    }
}
