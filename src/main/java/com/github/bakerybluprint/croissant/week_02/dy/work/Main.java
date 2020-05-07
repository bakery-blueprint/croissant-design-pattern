package com.github.bakerybluprint.croissant.week_02.dy.work;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String [] args) {

        Customer dy = new Customer("dynee313", "dy", 0, 0, false);        //도연 임직원
        Customer hs = new Customer("imesung", "hs", 0, 4000, false);     //혜성 임직원
        Customer jw = new Customer("mike6321", "jw", 1, 2000, false);     //준우 일반고객
        Customer sh = new Customer("leetsh", "sh", 2, 0, true);         //상현 일반고객 블랙컨슈머

        Product product1 = new Product(111111, 20000, 12345, 10); // 상품코드, 가격, 사은품코드, 재고
        Product product2 = new Product(222222, 10000, 0, 40);
        Product product3 = new Product(333333, 10000, 0, 0);

//        request(dy, product1);
//        System.out.println("---------------------------------------");
//        request(dy, product2);
//        System.out.println("---------------------------------------");
//        request(dy, product3);
//        System.out.println("---------------------------------------");

//        request(hs, product1);
//        System.out.println("---------------------------------------");
//        request(hs, product2);
//        System.out.println("---------------------------------------");
//        request(hs, product3);

//        request(jw, product1);
//        System.out.println("---------------------------------------");
//        request(jw, product2);
//        System.out.println("---------------------------------------");
//        request(jw, product3);

        request(sh, product1);
        System.out.println("---------------------------------------");
        request(sh, product2);
        System.out.println("---------------------------------------");
        request(sh, product3);
    }

    private static void request(Customer customer, Product product) {

        Order order = null;
        if (customer.gubun == 0) {
            order = new EmployeeOrder();
        } else {
            order = new GeneralOrder();
        }

        if (order != null) {
            Map<String, Object> result = order.orderSheetRequest(customer, product);

            if (result != null) {
                String status = (String) result.get("STATUS");
                String message = (String) result.get("MESSAGE");

                if ("E".equals(status)) {
                    System.out.println(message);
                } else {
                    System.out.println(message);
                    long prdPrc = product.prdPrc;

                    if (customer.point > 3000) {
                        customer.setPayment(new Point());
                        customer.pay(customer.point);

                        prdPrc = prdPrc - customer.point;
                    }

                    if (prdPrc > 0) {
                        System.out.println("**********결제수단을 입력해주세요!************");

                        Scanner sc = new Scanner(System.in);
                        String input = sc.next();

                        Payment payment = null;
                        if ("1".equals(input)) {
                            payment = new KakaoPay();
                        } else if ("2".equals(input)) {
                            payment = new CreditCard();
                        } else {
                            System.out.println("결제불가!");
                        }

                        if (payment != null) {
                            customer.setPayment(payment);
                            customer.pay(prdPrc);
                        }
                    }
                }
            } else {
                System.out.println("주문서 진입시 문제가 있습니다.");
            }
        }

    }
}
