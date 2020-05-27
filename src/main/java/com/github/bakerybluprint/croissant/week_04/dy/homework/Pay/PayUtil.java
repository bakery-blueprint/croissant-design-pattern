package com.github.bakerybluprint.croissant.week_04.dy.homework.Pay;

import com.github.bakerybluprint.croissant.week_04.dy.homework.Customer.Customer;
import com.github.bakerybluprint.croissant.week_04.dy.homework.Login.LoginUtil;
import com.github.bakerybluprint.croissant.week_04.dy.homework.product.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class PayUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayUtil.class);

    public void requestPay(Product product) {

        LOGGER.info("**********결제수단을 입력해주세요!************");

        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        Payment payment = null;
        if ("1".equals(input)) {
            payment = new KakaoPay();
        } else if ("2".equals(input)) {
            payment = new CreditCard();
        } else if ("3".equals(input)) {
            payment = new Cash();
        } else if ("4".equals(input)) {
            Customer customer = LoginUtil.getInstance().getCustomer();
            long point = customer.point;
            if (point > 0 && point > product.getPrdPrc()) {
                payment = new Point();
                customer.point = point - product.getPrdPrc();
            } else {
                LOGGER.info("**********포인트 부족************");
                this.requestPay(product);
            }
        } else {
            LOGGER.info("결제불가!");
        }

        if (payment != null) {
            pay(product.getPrdPrc(), payment);
        }
    }

    public void pay(long prdPrc, Payment payment) {
        payment.pay(prdPrc);
    }
}
