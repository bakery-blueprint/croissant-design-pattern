package com.github.bakerybluprint.croissant.week_03.dy.homework.Customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeneralCustomer extends Customer {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeneralCustomer.class);

    public GeneralCustomer(String userId, Long userNo, String userName, String userNickName, Long point) {
        super(userId, userNo, userName, userNickName, point);
    }
}
