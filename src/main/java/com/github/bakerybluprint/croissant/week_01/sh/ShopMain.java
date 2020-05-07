package com.github.bakerybluprint.croissant.week_01.sh;

import com.github.bakerybluprint.croissant.week_01.sh.customer.Customer;
import com.github.bakerybluprint.croissant.week_01.sh.payment.CreditCard;
import com.github.bakerybluprint.croissant.week_01.sh.payment.PayManager;
import com.github.bakerybluprint.croissant.week_01.sh.product.Product;
import com.github.bakerybluprint.croissant.week_01.sh.order.InitOrderImpl;
import com.github.bakerybluprint.croissant.week_01.sh.order.InitOrderInterface;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class ShopMain {
    public static void main(String[] args) {
        /* customer1 - 임직원, 포인트0 || customer2 - 일반, 포인트1000 || cusotmer3 - 일반, 포인트2000 || customer4 - 일반, 포인트3000, 블랙컨슈머 */
        Customer customer1 = new Customer("leetsh", "sh", 0, 0, false);
        Customer customer2 = new Customer("leetsh", "sh", 1, 1000, false);
        Customer customer3 = new Customer("leetsh", "sh", 1, 2000, false);
        Customer customer4 = new Customer("leetsh", "sh", 1, 3000, true);

        Product product1 = new Product(111111, 20000, 12345, 10);   // 상품1 - 2만, 사은품o, 재고10
        Product product2 = new Product(222222, 10000, 0, 40);       // 상품2 - 1만, 사은품x, 재고40
        Product product3 = new Product(222222, 10000, 0, 0);        // 상품3 - 1만, 사은품x, 재고0

        //1.주문서 진입가능한 상태인지 체크
        InitOrderInterface initOrder = new InitOrderImpl();
        Map<String, String> initResult = initOrder.orderSheetRequest(customer3, product2);

        //주문가능고객 판단
        if (!initResult.containsKey("E")) {
            log.info(initResult.get("S"));
            return;
        }

        //2.결제
        PayManager payManager = new PayManager();
        payManager.setPayable(new CreditCard());
        payManager.pay(customer3.getPoint());
    }
}
