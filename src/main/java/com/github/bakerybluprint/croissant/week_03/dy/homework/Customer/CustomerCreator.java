package com.github.bakerybluprint.croissant.week_03.dy.homework.Customer;

public abstract class CustomerCreator {

    public Customer create(String userId, String userName) {

        Long userNo = createUserNo(userId);
        String nickName = createUserNickName(userName);
        Long point = createUserPoint();

        Customer customer = createCustomer(userId, userNo, userName, nickName, point);
        return customer;
    }

    abstract protected Long createUserNo(String userId);
    abstract protected String createUserNickName(String userName);
    abstract protected Long createUserPoint();
    abstract protected Customer createCustomer(String userId, Long userNo, String userName, String nick, Long point);
}
