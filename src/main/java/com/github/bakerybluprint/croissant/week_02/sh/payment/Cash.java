package com.github.bakerybluprint.croissant.week_02.sh.payment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cash implements Payable {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void pay(long prc) { logger.info("** 현금 결제 **"); }
}
