package com.github.bakerybluprint.croissant.week_03.dy.homework.Order;

import com.github.bakerybluprint.croissant.week_03.dy.homework.Customer.Customer;
import com.github.bakerybluprint.croissant.week_03.dy.homework.Login.LoginUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeneralOrderCheck extends OrderCheck {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeneralOrderCheck.class);

    @Override
    public boolean checkGift(long giftNo) {
        LOGGER.info(giftNo + "사은품 재고체크");
        return true;
    }

    @Override
    protected boolean checkCustomerStatus() {
        Customer customer = LoginUtil.getInstance().getCustomer();
        if (customer != null) {
            if (customer.blackConsumerFlg) {
                LOGGER.info("블랙컨슈머 구매불가능상태");
                return false;
            } else {
                LOGGER.info("일반고객 구매가능상태");
                return true;
            }
        }
        return false;
    }
}
