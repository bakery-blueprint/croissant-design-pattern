package com.github.bakerybluprint.croissant.week_01.sh.customer;

import lombok.Data;

@Data
public class Customer {
    private String userId;       //ID
    private String userName;     //name
    private Integer gubun;       //0: 임직원, 1: 일반고객
    private long point;          // 보유포인트
    private boolean blackConsumerFlg;  //블랙컨슈머 여부

    public Customer(String userId, String userName, Integer gubun, long point, boolean blackConsumerFlg) {
        this.userId = userId;
        this.userName = userName;
        this.gubun = gubun;
        this.point = point;
        this.blackConsumerFlg = blackConsumerFlg;
    }
}
