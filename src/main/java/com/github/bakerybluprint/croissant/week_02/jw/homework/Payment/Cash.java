package com.github.bakerybluprint.croissant.week_02.jw.homework.Payment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Project : EffectiveStudy
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/05/06
 * Time : 9:56 오후
 */
public class Cash implements StrategyPayment{
    private static final Logger LOGGER = LoggerFactory.getLogger(Cash.class);

    @Override
    public void Payment() {
        LOGGER.info("현금 결제");
    }
}
