package com.github.bakerybluprint.croissant.week_04.dy.homework.Customer;

public class EmployeeCustomerCreator extends CustomerCreator {

    @Override
    protected Long createUserNo(String userId) {
        return Long.valueOf(userId.hashCode() + 1);
    }

    @Override
    protected String createUserNickName(String userName) {
        return userName + "임직원";
    }

    @Override
    protected Long createUserPoint() {
        return 10000L;
    }

    @Override
    protected Customer createCustomer(String userId, Long userNo, String userName, String nick, Long point) {
        return new EmployeeCustomer(userId, userNo, userName, nick, point);
    }
}
