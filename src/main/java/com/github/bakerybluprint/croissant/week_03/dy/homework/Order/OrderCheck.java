package com.github.bakerybluprint.croissant.week_03.dy.homework.Order;

import com.github.bakerybluprint.croissant.week_03.dy.homework.Login.LoginUtil;
import com.github.bakerybluprint.croissant.week_03.dy.homework.product.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public abstract class OrderCheck {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderCheck.class);

    public final Map<String, Object> orderSheetRequest(Product product) {

        Map<String, Object> result = new HashMap<String, Object>();

        if (!checkLoginStatus()) {
            result.put("STATUS", "E");
            result.put("MESSAGE", "로그인이 필요합니다.");
            return result;
        }

        if (!checkCustomerStatus()) {
            result.put("STATUS", "E");
            result.put("MESSAGE", "구매불가능한 상태입니다.");
            return result;
        }

        if (!checkProduct(product)) {
            result.put("STATUS", "E");
            result.put("MESSAGE", "구매불가능한 상품입니다.");
            return result;
        }

        if (product.giftNo > 0 && !checkGift(product.giftNo)) {
            result.put("STATUS", "E");
            result.put("MESSAGE", "구매불가능한 사은품이 포함되어 있습니다.");
            return result;
        }


        result.put("STATUS", "S");
        result.put("MESSAGE", "구매가능한 상태로 주문서로 진입합니다.");

        return result;
    }

    private boolean checkLoginStatus() {
        return LoginUtil.getInstance().checkLoginFlg();
    }

    private boolean checkProduct(Product product) {
        if (product.stock > 0) {
            LOGGER.info(product.prdCd + "상품 재고 체크 : " + product.stock);
            return true;
        } else {
            LOGGER.info(product.prdCd + "상품 재고 없음");
            return false;
        }
    }

    abstract protected boolean checkGift(long giftNo);
    abstract protected boolean checkCustomerStatus();
}


