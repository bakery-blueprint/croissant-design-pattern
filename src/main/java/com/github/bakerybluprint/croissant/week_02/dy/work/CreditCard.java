package com.github.bakerybluprint.croissant.week_02.dy.work;

public class CreditCard implements Payment {
    @Override
    public void pay(long prc) {
        System.out.println(prc + "원 신용카드로 결제");
    }
}
