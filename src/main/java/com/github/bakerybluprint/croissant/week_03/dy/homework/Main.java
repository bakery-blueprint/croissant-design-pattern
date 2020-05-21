package com.github.bakerybluprint.croissant.week_03.dy.homework;

import com.github.bakerybluprint.croissant.week_03.dy.homework.Customer.*;
import com.github.bakerybluprint.croissant.week_03.dy.homework.Login.LoginUtil;
import com.github.bakerybluprint.croissant.week_03.dy.homework.Order.EmployeeOrderCheck;
import com.github.bakerybluprint.croissant.week_03.dy.homework.Order.GeneralOrderCheck;
import com.github.bakerybluprint.croissant.week_03.dy.homework.Order.OrderCheck;
import com.github.bakerybluprint.croissant.week_03.dy.homework.Pay.PayUtil;
import com.github.bakerybluprint.croissant.week_03.dy.homework.product.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String [] args) {

        Product product1 = new Product(111111, 20000, 12345, 10); // 상품코드, 가격, 사은품코드, 재고
        Product product2 = new Product(222222, 10000, 0, 40);
        Product product3 = new Product(333333, 10000, 0, 0);

        CustomerCreator customerCreator = new EmployeeCustomerCreator();
        Customer customer = customerCreator.create("dynee313", "doyeon");
        LoginUtil.getInstance().login(customer);

        OrderCheck  orderCheck = null;
        if (customer instanceof EmployeeCustomer) {
            orderCheck = new EmployeeOrderCheck();
        } else if (customer instanceof GeneralCustomer) {
            orderCheck = new GeneralOrderCheck();
        }
        Map<String, Object> result = orderCheck.orderSheetRequest(product2);

        if (result != null) {
            String status = (String) result.get("STATUS");
            String message = (String) result.get("MESSAGE");

            LOGGER.info(message);

            if ("S".equals(status)) {
                long prdPrc = product2.prdPrc;
                PayUtil payUtil = new PayUtil();
                payUtil.requestPay(product1);
            }
        }
    }
}
