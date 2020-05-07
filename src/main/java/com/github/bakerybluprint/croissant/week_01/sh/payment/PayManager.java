package com.github.bakerybluprint.croissant.week_01.sh.payment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PayManager {
    //접근점
    private Payable payable;

    public void pay(long prc) {
        if (payable == null) {
            log.info("결제 방식을 선택하세요.");
        } else {
            payable.pay(prc);
        }
    }

    //결제 방식 변경
    public void setPayable(Payable payable) {
        this.payable = payable;
    }
}
