package com.github.bakerybluprint.croissant.week_02.dy.work;

public class Cash implements Payment {
    @Override
    public void pay(long prc) {
        System.out.println(prc + "원 현금 결제");
    }
}
