package com.github.bakerybluprint.croissant.week_02.dy.work;

public class Customer {

    public String userId;   //ID
    public String userName;   //name
    public int gubun;     //0: 임직원, 1: 일반고객
    public long point;      // 보유포인트
    public boolean blackConsumerFlg;  //

    private Payment payment;

    public Customer(String userId, String userName, int gubun, long point, boolean blackConsumerFlg) {
        this.userId = userId;
        this.userName = userName;
        this.gubun = gubun;
        this.point = point;
        this.blackConsumerFlg = blackConsumerFlg;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void pay(long point) {
        this.payment.pay(point);
    }
}