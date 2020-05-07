package com.github.bakerybluprint.croissant.week_02.dy.work;

public class KakaoPay implements Payment {
    @Override
    public void pay(long prc) {
        System.out.println(prc + "원 카카오페이로 결제");
    }
}
