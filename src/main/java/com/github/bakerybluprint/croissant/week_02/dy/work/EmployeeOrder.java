package com.github.bakerybluprint.croissant.week_02.dy.work;

public class EmployeeOrder extends Order{

    @Override
    public boolean checkGift(long giftNo) {
        System.out.println("임직원은 사은품 제공 불가");
        return false;
    }

    @Override
    public boolean checkCustomerStatus(Customer customer) {
        if (customer.point > 0) {
            System.out.println("임직원 포인트 보유");
            return true;
        } else {
            System.out.println("임직원 포인트 보유X");
            return false;
        }
    }
}
