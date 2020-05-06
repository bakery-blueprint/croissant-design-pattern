package com.github.bakerybluprint.croissant.week_02.jw.homework.Order;


import com.github.bakerybluprint.croissant.week_02.jw.homework.Customer.Customer;

/**
 * Project : EffectiveStudy
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/05/03
 * Time : 2:02 오전
 */
// TODO:  junwoochoi 2020/05/06 1:50 오전
// 템플릿 메서드 패턴 구현 - 임직원 일 경우 주문 가능 상태 체크
public class EmployeeCustomerOrderCheck extends OrderCheck{

    @Override
    protected boolean authorizationCheck(String userId) {
        Customer customer = new Customer(userId);

        // TODO: [일반 고객일 경우 보유 포인트 체크] junwoochoi 2020/05/06 1:52 오전
        // 일반고객일 경우 블랙컨슈머 여부를 체크하며 블랙컨슈머이면 주문 불가
        return customer.pointCheck(userId);

    }
}
