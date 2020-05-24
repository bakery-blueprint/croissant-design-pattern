package com.github.bakerybluprint.croissant.week_04.dy.homework.Customer;

public class GeneralCustomerCreator extends CustomerCreator {

    @Override
    protected Long createUserNo(String userId) {
        return Long.valueOf(userId.hashCode());
    }

    @Override
    protected String createUserNickName(String userName) {
        return userName + "고객";
    }

    @Override
    protected Long createUserPoint() {
        return 1000L;
    }

    @Override
    protected Customer createCustomer(String userId, Long userNo, String userName, String nick, Long point) {
        return new GeneralCustomer(userId, userNo, userName, nick, point);
    }
}
