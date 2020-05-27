package com.github.bakerybluprint.croissant.week_03.dy.homework.Customer;


public abstract class Customer {

    public String userId;       //ID
    public String userName;     //name
    public String userNickName; //닉네임
    public long point;          // 보유포인트
    public boolean blackConsumerFlg;  // 블랙컨슈머

    public Customer(String userId, Long userNo, String userName, String userNickName, Long point) {
        this.userId = userId;
        this.userName = userName;
        this.userNickName = userNickName;
        this.point = point;
        this.blackConsumerFlg = false;
    }

    public void setBlackConsumerFlg(boolean flag) {
        this.blackConsumerFlg = flag;
    }

    public void setPoint(long point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userNickName='" + userNickName + '\'' +
                ", point=" + point +
                ", blackConsumerFlg=" + blackConsumerFlg +
                '}';
    }
}