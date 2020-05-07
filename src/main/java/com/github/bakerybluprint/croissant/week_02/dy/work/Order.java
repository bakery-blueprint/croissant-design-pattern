package com.github.bakerybluprint.croissant.week_02.dy.work;

import java.util.HashMap;
import java.util.Map;

public abstract class Order {

    public final Map<String, Object> orderSheetRequest(Customer customer, Product product) {

        Map<String, Object> result = new HashMap<String, Object>();

        if (!checkLoginStatus()) {
            result.put("STATUS", "E");
            result.put("MESSAGE", "로그인이 필요합니다.");
            return result;
        }

        if (!checkCustomerStatus(customer)) {
            result.put("STATUS", "E");
            result.put("MESSAGE", "구매불가능한 상태입니다.");
            return result;
        }

        if (!checkProduct(product)) {
            result.put("STATUS", "E");
            result.put("MESSAGE", "구매불가능한 상품입니다.");
            return result;
        }

        if (product.giftNo > 0) {
            if (!checkGift(product.giftNo)) {
                result.put("STATUS", "E");
                result.put("MESSAGE", "구매불가능한 사은품이 포함되어 있습니다.");
                return result;
            }
        }

        result.put("STATUS", "S");
        result.put("MESSAGE", "구매가능한 상태로 주문서로 진입합니다.");

        return result;
    }

    private boolean checkLoginStatus() {
        System.out.println("정상적인 로그인 상태인지 쿠키값 체크");
        return true;
    }

    private boolean checkProduct(Product product) {
        if (product.stock > 0) {
            System.out.println(product.prdCd + "상품 재고 체크 : " + product.stock);
            return true;
        } else {
            System.out.println(product.prdCd + "상품 재고 없음");
            return false;
        }
    }

    abstract protected boolean checkGift(long giftNo);
    abstract protected boolean checkCustomerStatus(Customer customer);


}

