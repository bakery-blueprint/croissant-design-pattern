package com.github.bakerybluprint.croissant.week_02.jw.homework.Payment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Project : EffectiveStudy
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/05/06
 * Time : 9:55 오후
 */
public class CreditCard implements StrategyPayment{
    private static final Logger LOGGER = LoggerFactory.getLogger(CreditCard.class);

    @Override
    public void Payment() {
        LOGGER.info("신용카드 결제");
    }
}
