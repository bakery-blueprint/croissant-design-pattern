package com.github.bakerybluprint.croissant.week_02.jw.homework.Order;

import com.github.bakerybluprint.croissant.week_02.jw.homework.Customer.Customer;

/**
 * Project : croissant
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 1:10 오전
 */
public class EmployeeCustomerOrderCheckCreator extends OrderCheckCreator{
    @Override
    protected CustomerOrderCheck createOrderCheck() {
        return new EmployeeCustomerOrderCheck();
    }

    @Override
    protected boolean authorizationCheck(String userId) {
        Customer customer = Customer.getInstance();

        // TODO: [일반 고객일 경우 보유 포인트 체크] junwoochoi 2020/05/06 1:52 오전
        // 일반고객일 경우 블랙컨슈머 여부를 체크하며 블랙컨슈머이면 주문 불가
        return customer.pointCheck(userId);

    }

}
