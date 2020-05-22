package com.github.bakerybluprint.croissant.week_02.sh.order;

import com.github.bakerybluprint.croissant.week_02.sh.customer.Customer;
import com.github.bakerybluprint.croissant.week_02.sh.product.Product;

import java.util.Map;

/**
 * Template Method Pattern을 적용하여, 주문서 진입 과정을 구현한다.
 */
public interface InitOrderInterface {

    boolean checkLoginStatus();

    boolean checkCustomerStatus(Customer customer);

    boolean checkProduct(Product product);

    boolean checkGift(String giftNo);

    //Template Method
    Map<String, String> orderSheetRequest(Customer customer, Product product);

}
