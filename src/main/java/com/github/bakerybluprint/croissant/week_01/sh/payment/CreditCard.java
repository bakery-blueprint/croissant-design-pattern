package com.github.bakerybluprint.croissant.week_01.sh.payment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreditCard implements Payable {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void pay(long prc) {
        logger.info("** 신용카드 결제 **");
    }
}
