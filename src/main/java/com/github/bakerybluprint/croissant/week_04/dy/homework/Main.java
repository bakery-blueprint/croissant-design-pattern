package com.github.bakerybluprint.croissant.week_04.dy.homework;

import com.github.bakerybluprint.croissant.week_04.dy.homework.Customer.*;
import com.github.bakerybluprint.croissant.week_04.dy.homework.Login.LoginUtil;
import com.github.bakerybluprint.croissant.week_04.dy.homework.Order.EmployeeOrderCheck;
import com.github.bakerybluprint.croissant.week_04.dy.homework.Order.GeneralOrderCheck;
import com.github.bakerybluprint.croissant.week_04.dy.homework.Order.OrderCheck;
import com.github.bakerybluprint.croissant.week_04.dy.homework.Pay.PayUtil;
import com.github.bakerybluprint.croissant.week_04.dy.homework.product.Product;
import com.github.bakerybluprint.croissant.week_04.dy.homework.product.Product1Builder;
import com.github.bakerybluprint.croissant.week_04.dy.homework.product.ProductBuilder2;
import com.github.bakerybluprint.croissant.week_04.dy.homework.product.ProductFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String [] args) {

        //Builder Pattern1 사용하여 product1 생성
        ProductFactory factory = new ProductFactory();
        factory.setProductBuilder(new Product1Builder());
        factory.make();
        Product product1 = factory.getProduct();

        //Builder Pattern2 사용.
        Product product3 = ProductBuilder2
                .start()
                .setPrdCd(33333)
                .setPrdPrc(10000)
                .setGiftNo(0)
                .setStock(0)
                .make();


        CustomerCreator customerCreator = new EmployeeCustomerCreator();
        Customer customer = customerCreator.create("dynee313", "doyeon");
        LoginUtil.getInstance().login(customer);

        OrderCheck orderCheck = null;
        if (customer instanceof EmployeeCustomer) {
            orderCheck = new EmployeeOrderCheck();
        } else if (customer instanceof GeneralCustomer) {
            orderCheck = new GeneralOrderCheck();
        }
        Map<String, Object> result = orderCheck.orderSheetRequest(product1);

        if (result != null) {
            String status = (String) result.get("STATUS");
            String message = (String) result.get("MESSAGE");

            LOGGER.info(message);

            if ("S".equals(status)) {
                long prdPrc = product1.getPrdPrc();
                PayUtil payUtil = new PayUtil();
                payUtil.requestPay(product1);
            }
        }
    }


}
