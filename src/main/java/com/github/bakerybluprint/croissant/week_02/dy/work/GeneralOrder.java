package com.github.bakerybluprint.croissant.week_02.dy.work;

public class GeneralOrder extends Order{

    @Override
    public boolean checkGift(long giftNo) {
        System.out.println(giftNo + "사은품 재고체크");
        return true;
    }

    @Override
    public boolean checkCustomerStatus(Customer customer) {
        if (customer.blackConsumerFlg) {
            System.out.println("블랙컨슈머 구매불가능상태");
            return false;
        } else {
            System.out.println("일반고객 구매가능상태");
            return true;
        }
    }
}
