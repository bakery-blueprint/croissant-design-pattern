package com.github.bakerybluprint.croissant.week_02.dy.work;

public class Point implements Payment {
    @Override
    public void pay(long prc) {
        System.out.println(prc + "원 포인트로 결제");
    }
}
