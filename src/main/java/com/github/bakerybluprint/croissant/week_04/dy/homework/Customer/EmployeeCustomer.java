package com.github.bakerybluprint.croissant.week_04.dy.homework.Customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeCustomer extends Customer {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeCustomer.class);

    public EmployeeCustomer(String userId, Long userNo, String userName, String userNickName, Long point) {
        super(userId, userNo, userName, userNickName, point);
    }
}
