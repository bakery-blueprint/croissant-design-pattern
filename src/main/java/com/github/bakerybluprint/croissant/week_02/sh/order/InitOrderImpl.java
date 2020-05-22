package com.github.bakerybluprint.croissant.week_02.sh.order;

import com.github.bakerybluprint.croissant.week_02.sh.customer.Customer;
import com.github.bakerybluprint.croissant.week_02.sh.product.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class InitOrderImpl implements InitOrderInterface {
    /**
     *  1. 주문서에 진입 시 로그인 상태인지 체크한다. checkLoginStatus() : boolean
     *  - Cookie 값에 로그인 한 정보가 없으면 진입불가
     */
    @Override
    public boolean checkLoginStatus() {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        if(ObjectUtils.isEmpty(attributes)) return false;
//        Cookie[] cookies = attributes.getRequest().getCookies();
//        if (!ObjectUtils.isEmpty(cookies)) {
//            for (Cookie cookie: cookies) {
//                //로그인 상태 체크
//                if ("loginFlag".equals(cookie.getName())) {
//                    if ("Y".equals(cookie.getValue()))
                        log.info("** 로그인 확인 **");
                        return true;
//                }
//            }
//        }
//        logger.info("로그인 상태가 아닙니다.");
//        return false;
    }
    /**
     *  2. 고객이 주문가능한 상태인지 체크한다. checkCustomerStatus(Customer customer) : boolean
     *  - 일반고객과 임직원고객에 대해 주문가능 상태 체크 알고리즘이 다르다
     *  - 일반고객(1)일 경우 블랙컨슈머 여부를 체크하며 블랙컨슈머이면 주문 불가
     *  - 임직원(0)은 보유 포인트 여부를 체크하며 보유 포인트가 0원일 경우 주문 불가
     */
    @Override
    public boolean checkCustomerStatus(Customer customer) {
        Integer membership = customer.getGubun();
        if (membership == 1) {
            if (customer.isBlackConsumerFlg()) {
                log.info("블랙컨슈머 고객이므로 주문이 불가합니다.");
                return false;
            }
        }

        if (membership == 0) {
            if (customer.getPoint() == 0) {
                log.info("보유 포인트가 없으므로 주문이 불가합니다.");
                return false;
            }
        }
        return true;
    }

    /**
     *  3. 상품에 대한 재고를 체크한다. checkProduct(Product product) : boolean
     *  - 재고가 없으면 주문 불가
     */
    @Override
    public boolean checkProduct(Product product) {
        if (product.getStock() < 1) {
            log.info("상품 재고가 부족합니다.");
            return false;
        }
        return true;
    }

    /**
     *  4. 사은품에 대한 재고를 체크한다. checkGift(String giftNo) : boolean
     *  - 일반 고객(1)은 사은품 재고를 체크하여 사은품 재고가 없으면 주문 불가
     *  - 임직원(0)은 사은품이 있으면 주문 불가
     */
    @Override
    public boolean checkGift(String giftNo) {
        //사은품코드(giftNo)가 0일 경우 사은품 없으므로 true 리턴
        if ("0".equals(giftNo)) return true;

        //사은품에 대한 재고 체크
        Product gift = new Product();
        gift.setPrdCd(Long.parseLong(giftNo));
        return checkProduct(gift);
    }

    /**
     * ### 주문서 진입가능한 상태인지 체크한다.
     * - 상품을 주문하기 위한 주문서 진입 전 주문가능한 상태인지 일련의 과정을 체크해야한다.
     * - Method명 :orderSheetRequest(Customer customer, Product product) : Map<String, String>
     * - return type : Map<String, String> 결과값으로  Status(E:주문가능, S:주문불가)와 Message를 리턴받는다.
     */
    @Override
    public Map<String, String> orderSheetRequest(Customer customer, Product product) {
        //Return Value
        Map<String, String> preOrderStatus = new HashMap<>();

        //1.로그인 상태 체크
        if (!checkLoginStatus()) {
            preOrderStatus.put("status","S");
            preOrderStatus.put("message","로그인한 고객이 아닙니다.");
            return preOrderStatus;
        }

        //2.고객의 주문가능 여부 판단
        if (!checkCustomerStatus(customer)) {
            preOrderStatus.put("status","S");
            preOrderStatus.put("message","주문 가능한 고객이 아닙니다.");
            return preOrderStatus;
        }

        //3.주문 상품 재고 체크
        if (!checkProduct(product)) {
            preOrderStatus.put("status","S");
           preOrderStatus.put("message","주문 상품의 재고가 부족합니다.");
           return preOrderStatus;
        }

        //4.사은품 재고 체크
        if (!checkGift(String.valueOf(product.getGiftNo()))) {
            preOrderStatus.put("status","S");
            preOrderStatus.put("message","사은품 재고가 부족합니다.");
            return preOrderStatus;
        }

        preOrderStatus.put("status","E");
        preOrderStatus.put("message", "주문 가능");
        return preOrderStatus;
    }
}
