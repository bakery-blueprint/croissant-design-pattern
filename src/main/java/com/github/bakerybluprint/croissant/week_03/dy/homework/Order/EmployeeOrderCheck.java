package com.github.bakerybluprint.croissant.week_03.dy.homework.Order;

import com.github.bakerybluprint.croissant.week_03.dy.homework.Customer.Customer;
import com.github.bakerybluprint.croissant.week_03.dy.homework.Login.LoginUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeOrderCheck extends OrderCheck {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeOrderCheck.class);

    @Override
    public boolean checkGift(long giftNo) {
        LOGGER.info("임직원은 사은품 제공 불가");
        return false;
    }

    @Override
    protected boolean checkCustomerStatus() {
        Customer customer = LoginUtil.getInstance().getCustomer();
        if (customer != null) {
            if (customer.point > 0) {
                LOGGER.info("임직원 포인트 보유");
                return true;
            } else {
                LOGGER.info("임직원 포인트 보유X");
                return false;
            }
        }
        return false;
    }
}
